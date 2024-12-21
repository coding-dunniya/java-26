package threadlocal;

public class ThreadLocalDemo {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) {
        System.out.println("get value ==> " + THREAD_LOCAL.get());
        THREAD_LOCAL.set("hello world");
        System.out.println("get value ==> " + THREAD_LOCAL.get());

        THREAD_LOCAL.remove();
        System.out.println("get value ==> " + THREAD_LOCAL.get());
    }
}
