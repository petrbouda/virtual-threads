package pbouda.vthreads;

import java.util.List;
import java.util.stream.IntStream;

public class SomeJob {

    public static void execute() {
        List<String> list = IntStream.range(0, 50)
                .mapToObj(i -> Thread.currentThread() + " - " + i)
                .toList();

        String[] newArray = new String[50];
        System.arraycopy(list.toArray(new String[50]), 0, newArray, 0, 50);
    }
}
