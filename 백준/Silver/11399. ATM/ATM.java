import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        AtomicInteger sum = new AtomicInteger(0);

        int value = br.lines().limit(1)
            .flatMapToInt(line -> Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt))
            .sorted()
            .map(num -> sum.addAndGet(num))
            .sum();

        System.out.println(value);

    }

}