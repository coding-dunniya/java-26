package threadgroup;

public class MyThread extends Thread {

    private boolean suspendFlag = false;

    public MyThread(String name, ThreadGroup group) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(getName() + ": " + i);
                Thread.sleep(1000);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception in my thread: " + ex.getMessage() + " thread name: " + getName());
        }
        System.out.println("Thread Exiting: " + getName());
    }

    public synchronized void mySuspend() {
        suspendFlag = true;
    }

    public synchronized void myResume() {
        suspendFlag = false;
        notify();
    }
}
