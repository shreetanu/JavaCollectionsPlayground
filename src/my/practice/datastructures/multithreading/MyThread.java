package my.practice.datastructures.multithreading;

class ThreadsImpl extends Thread {
    @Override
    public void run() {
        System.out.println("WELCOME TO MY THREAD");
    }
}
public class MyThread {
    public static void main(String[] args) {
        ThreadsImpl t1 = new ThreadsImpl();
        t1.start();
    }
}
