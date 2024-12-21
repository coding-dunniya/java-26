package thread;

public class DaemonDemo {

    public static void main(String[] args) {
        DaemonRunnableTask task = new DaemonRunnableTask();
        Thread t = new Thread(task);
        t.setDaemon(true);
        t.start();
        System.out.println("thread started");
    }
}

class DaemonRunnableTask implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread t = Thread.currentThread();
        String name = t.getName();
        boolean daemon = t.isDaemon();
        System.out.println("Hello world from runnable thread ==> " + name + " is daemon ==> " + daemon);
    }
}
