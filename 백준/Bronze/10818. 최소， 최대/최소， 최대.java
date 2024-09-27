import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int min = IntStream.of(arr).min().getAsInt();
        int max = IntStream.of(arr).max().getAsInt();

        System.out.println(min + " " + max);

    }

}