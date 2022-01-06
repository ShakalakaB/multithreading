package fun.aldora.multithreading.exception;

public class HandleThreadException {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("inside " + Thread.currentThread().getName());
            if (1 == 1) {
                throw new RuntimeException("test");
            }
        });
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.printf("Thread: %s, errorMsg: %s%n", t.getName(), e.getMessage());
            }
        });
        thread.start();
    }
}
