import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[11];
        for (int i = 1; i <= 10; i++) {
            int num = Integer.parseInt(br.readLine());
            dp[i] = dp[i - 1] + num;
        }

        int v = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 1; i <= 10; i++) {
            if (Math.abs(100 - dp[i]) <= v) {
                v = Math.abs(100 - dp[i]);
                idx = i;
            } else {
                break;
            }
        }

        System.out.println(dp[idx]);

    }

}
