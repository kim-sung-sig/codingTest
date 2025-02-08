import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int n = N;
        int count = n/5;
        n %= 5;

        while(n != 0) {
            if (n % 3 == 0) {
                count += n/3;
                n %= 3;
            } else {
                count--;
                n += 5;
            }

            if (n > N) {
                count = -1;
                break;
            }
        }

        System.out.println(count);
    }

}
