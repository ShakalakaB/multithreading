package fun.aldora.thread.creation;

public class ThreadCreation {
    public static void main(String[] args) {
        String threadName = "A";
        Thread thread = new Thread(() -> {
            System.out.println("in thread: " + Thread.currentThread().getName());
            System.out.println("thread " + Thread.currentThread().getName() + ": priority is " + Thread.currentThread().getPriority());
        });

        thread.setName("thread " + threadName);
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        thread.start();
        System.out.println("in thread: " + Thread.currentThread().getName() + " after starting a new thread");
    }
}
