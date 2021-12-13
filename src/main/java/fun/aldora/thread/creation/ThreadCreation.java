package fun.aldora.thread.creation;

public class ThreadCreation {
    public static void main(String[] args) {
        String threadName = "A";
        Thread thread = new Thread(() -> {
            System.out.println("in thread: " + Thread.currentThread().getName());
            System.out.println("thread " + Thread.currentThread().getName() + ": priority is " + Thread.currentThread().getPriority());
            throw new RuntimeException("intentional exception");
        });

        thread.setName(threadName);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Thread: " + t.getName() + ", error: " + e.getMessage());
            }
        });

        System.out.println("in thread: " + Thread.currentThread().getName() + ", before starting a new thread");
        thread.start();
        System.out.println("in thread: " + Thread.currentThread().getName() + ", after starting a new thread");
    }
}
