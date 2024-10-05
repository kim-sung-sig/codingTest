import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int result = 0;
        for(int i = 1; i <= N; i++) {

            int val = calc(i);

            if(val == N) {
                result = i;
                break;
            }

        }

        System.out.println(result);

    }

    private static int calc(int a) {
        int sum = 0;
        int tempA = a;
        while(tempA > 0) {
            sum += tempA % 10;
            tempA /= 10;
        }
        return a + sum;
    }

}