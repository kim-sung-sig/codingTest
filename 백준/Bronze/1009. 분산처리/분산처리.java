import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];

            int tempA = a % 10;
            if(tempA == 0) {
                result[i] = 10;
            } else {
                int tempB = (b-1) % 4 + 1;
                int temp = (int) Math.pow(tempA, tempB);
                result[i] = temp % 10;
            }

        }
        br.close();

        for(int i : result) {
            System.out.println(i);
        }

    }

}