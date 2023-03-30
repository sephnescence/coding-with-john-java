public class ExtendsThreadVsImplementsRunnableExample {
    public static void main(String[] args) {
        Thread myThreadImplementsRunnable = new Thread(new MyThreadImplementsRunnable("MyThreadImplementsRunnable 1"));
        myThreadImplementsRunnable.start();
        myThreadImplementsRunnable.interrupt();

        Thread myThreadExtendsThread = new MyThreadExtendsThread("myThreadExtendsThread 1");

        /*
        So a note on below. If for whatever reason you wanted to run what the thread has to do, but not
            actually in a thread, then you can do this

        myThreadExtendsThread.run();
        */

        myThreadExtendsThread.start();
        myThreadExtendsThread.interrupt();

        /*
        Additional notes
        - Threads throwing an exception won't block/stop the main thread or each other
        - Similarly, an exception in the main thread won't stop the threads
        */
    }
}

class MyThreadExtendsThread extends Thread {
    private String name;

    public MyThreadExtendsThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " running...");

        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " log # " + i);

            try {
                Thread.sleep(1000); // Milliseconds
            } catch (InterruptedException e) {
                System.out.println(name + " Interrupted");
                break;
            }
        }
    }
}

/*
The advantage to doing it this way is that MyThread is free to extend another
    class, as you can only extend one class in Java
 */
class MyThreadImplementsRunnable implements Runnable {
    private String name;

    public MyThreadImplementsRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " running...");

        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " log # " + i);

            try {
                Thread.sleep(1000); // Milliseconds
            } catch (InterruptedException e) {
                System.out.println(name + " Interrupted");
                break; // In this example file I've interrupted both these classes. If you don't break it will still continue running
            }
        }
    }
}