package pbouda.vthreads;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Application {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        while (true) {
            executor.submit(() -> {
                try {
                    SomeJob.execute();
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    public static class SomeJob {

        public static void execute() {
            List<String> list = IntStream.range(0, 50)
                    .mapToObj(i -> Thread.currentThread() + " - " + i)
                    .toList();

            String[] newArray = new String[50];
            System.arraycopy(list.toArray(new String[50]), 0, newArray, 0, 50);
        }
    }
}
