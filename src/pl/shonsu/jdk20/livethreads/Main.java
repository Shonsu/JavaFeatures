package pl.shonsu.jdk20.livethreads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        ThreadFactory threadFactory = Thread
                .ofVirtual()
                .name("task-", 0)
                .factory();
        int cpus = Runtime.getRuntime().availableProcessors();

        try (var executor = Executors.newThreadPerTaskExecutor(threadFactory)) {
            IntStream
                    .range(0, cpus + 1)
                    .forEach(i -> executor.submit(() -> {
                                System.out.println(Thread.currentThread());
                            })
                    );

        }
    }

    static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
