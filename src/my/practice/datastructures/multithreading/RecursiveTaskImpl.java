package my.practice.datastructures.multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskImpl extends RecursiveTask<Integer> {
    private final int n;
    public RecursiveTaskImpl(int n) {
        this.n = n;
    }
    @Override
    protected Integer compute() {
        if(n <= 1)
            return n;
        RecursiveTaskImpl task1 = new RecursiveTaskImpl(n-1);
        RecursiveTaskImpl task2 = new RecursiveTaskImpl(n-2);

        task1.fork();
        task2.fork();

        int sum = 0;
        sum += task1.join();
        sum+= task2.join();
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        RecursiveTaskImpl task = new RecursiveTaskImpl(6);

        System.out.println(pool.invoke(task));
    }
}
