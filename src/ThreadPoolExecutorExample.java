import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        ExecutorService threadpoolExecutorObject = new ThreadPoolExecutor(1,
                5,
                0l,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(2));
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            threadpoolExecutorObject.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread Pool Executor" +
                        "Thread Task " + taskId +
                        "Executed by Thread" + Thread.currentThread().getName());
            });
        }
    }
}
