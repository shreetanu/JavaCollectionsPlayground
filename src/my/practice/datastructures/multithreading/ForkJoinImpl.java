package my.practice.datastructures.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinImpl extends RecursiveAction {
    List<Integer> list;
    private final int threshold = 2;
    public ForkJoinImpl(List<Integer> l) {
        this.list = l;
    }
    @Override
    protected void compute() {
        if(list.size() < threshold) {
            System.out.println(list.get(0));
        }
        else {
            List<Integer> newL1 = new ArrayList<>();
            for(int i=0;i< list.size()/2;i++) {
                newL1.add(list.get(i));
            }
            List<Integer> newL2 = new ArrayList<>();
            for(int i=list.size()/2;i< list.size();i++) {
                newL2.add(list.get(i));
            }
            ForkJoinImpl fork1 = new ForkJoinImpl(newL1);
            ForkJoinImpl fork2 = new ForkJoinImpl(newL2);
            fork1.fork();
            fork2.fork();

            fork1.join();
            fork2.join();
            /***
             * Parallel execution is happening in invokeAll()
             *  There's no guaranteed order of thread execution
             * The ForkJoinPool manages its threads independently
             */
//            invokeAll(fork1,fork2);
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        List<Integer> li = new ArrayList<>();
        for(int i=1;i<=100;i++) {
            li.add(i);
        }
        ForkJoinImpl forkJoin = new ForkJoinImpl(li);
        pool.invoke(forkJoin);
    }
}
