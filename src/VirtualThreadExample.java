public class VirtualThreadExample {
    public static void main(String[] args) {
        final int numberOfThreads = 10_000_0;

        Runnable objRunnable = () -> {
            String name = "Instagram";
            System.out.println("fetching data from " + name);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        };

        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = Thread.ofVirtual().unstarted(objRunnable);
            //thread.setDaemon(true);
            thread.start();
            String str = String.format("Thread number %s", i);
            System.out.println(str);
        }
    }
}
