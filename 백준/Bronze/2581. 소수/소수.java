import java.io.BufferedReader;
import java.util.Arrays;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dp = new int[m + 1];

        // 소수 계산
        Arrays.fill(dp, 1);
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= m; i++) {
            if(dp[i] == 1) {
                for (int j = i * i; j <= m; j += i) {
                    dp[j] = 0;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = n; i <= m; i++) {
            if (dp[i] == 1) {
                sum += i;
                min = Math.min(min, i);
            }
        }
        if(sum == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(min);

    }
}