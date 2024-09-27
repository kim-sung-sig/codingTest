import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        double[] arr = Stream.of(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double a = arr[0];
        double b = arr[1];

        System.out.println(a/b);
        br.close();

    }

}