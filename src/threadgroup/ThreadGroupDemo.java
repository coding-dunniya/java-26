package threadgroup;

public class ThreadGroupDemo {

    public static void main(String[] args) throws Exception {
        ThreadGroup groupA = new ThreadGroup("group-a");
        ThreadGroup groupB = new ThreadGroup("group-b");

        MyThread t1 = new MyThread("one", groupA);
        MyThread t2 = new MyThread("two", groupA);

        MyThread t3 = new MyThread("three", groupB);
        MyThread t4 = new MyThread("four", groupB);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("suspending group A");

        Thread[] groupAThreads = new Thread[groupA.activeCount()];
        groupA.enumerate(groupAThreads);

        for (Thread t : groupAThreads) {
            ((MyThread) t).mySuspend();
        }

        System.out.println("sleeping main thread");
        Thread.sleep(5000);

        System.out.println("resuming group A");

        for (Thread t : groupAThreads) {
            ((MyThread) t).myResume();
        }

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("exiting main thread");
    }
}
