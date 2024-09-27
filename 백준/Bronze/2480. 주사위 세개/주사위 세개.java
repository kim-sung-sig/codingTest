import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long count = IntStream.of(n).distinct().count();

        if(count == 1) {
            System.out.println(10000 + n[0] * 1000);
        }
        else if(count == 2) {
            int dupl = n[0];
            if(n[1] == n[2]) {
                dupl = n[1];
            }
            System.out.println(1000 + dupl * 100);
        }
        else {
            System.out.println(IntStream.of(n).max().getAsInt() * 100);
        }
    }

}