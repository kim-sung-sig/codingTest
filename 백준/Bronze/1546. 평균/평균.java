import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] scores = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double max = IntStream.of(scores).max().getAsInt();
        double result = IntStream.of(scores).mapToDouble(i -> i / max * 100).average().getAsDouble();
        System.out.println(result);
    }

}