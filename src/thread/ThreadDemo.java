package thread;

public class ThreadDemo {

    public static void main(String[] args) {
        // thread class constructors

        Thread t1 = new Thread();   // default constructor
        Thread t2 = new Thread(new RunnableTask());
        Thread t3 = new Thread(new RunnableTask(), "custom-thread-1");
        Thread t4 = new Thread("custom-thread-2");

        // create thread group
        ThreadGroup group = new ThreadGroup("custom-thread-group");

        Thread t5 = new Thread(group, new RunnableTask());
        Thread t6 = new Thread(group, new RunnableTask(), "custom-thread-3");
        Thread t7 = new Thread(group, "custom-thread-4");

        // methods in thread class
        Thread.dumpStack();

        final Object lock = new Object();
        System.out.println("holds lock ==> " + Thread.holdsLock(lock));
        synchronized (lock) {
            System.out.println("holds lock inside synchronized ==> " + Thread.holdsLock(lock));
        }

        Thread mainThread = Thread.currentThread();

        System.out.println("get id ==> " + mainThread.getId());
        System.out.println("get name ==> " + mainThread.getName());
        System.out.println("get priority ==> " + mainThread.getPriority());
        System.out.println("get state ==> " + mainThread.getState());

        mainThread.setName("ritesh ka thread");
        mainThread.setPriority(Thread.MAX_PRIORITY);

        StackTraceElement[] stackTraceElements = mainThread.getStackTrace();
        System.out.println("stack trace ==> " + stackTraceElements);

        System.out.println("thread group ==> " + mainThread.getThreadGroup());

        System.out.println("is alive ==> " + mainThread.isAlive());
        System.out.println("is daemon ==> " + mainThread.isDaemon());

        int count = Thread.activeCount();
        System.out.println("total active count ==> " + count);

        Thread[] threads = new Thread[count];
        Thread.enumerate(threads);
        for (Thread t : threads) {
            System.out.println("threads from enumerate ==> " + t);
        }
    }
}

class RunnableTask implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        String name = t.getName();
        System.out.println("Hello world from runnable task with thread name ==> " + name);
    }
}
