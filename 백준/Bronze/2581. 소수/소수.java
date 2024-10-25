import java.io.BufferedReader;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dp = new int[m + 1];

        // 소수 계산
        for (int i = 2; i <= m; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                dp[i] = 1;
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