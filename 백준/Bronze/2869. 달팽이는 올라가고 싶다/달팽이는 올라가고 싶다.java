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
        int v = q[2];

        int sub = a - b;
        int days = (v - a) / sub + 1;

        if((v - a) % sub != 0) {
            days++;
        }
        System.out.println(days);
    }
}