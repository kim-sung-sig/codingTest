import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] q = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = q[0];
        int b = q[1];
        System.out.println(a + b);
    }
}
