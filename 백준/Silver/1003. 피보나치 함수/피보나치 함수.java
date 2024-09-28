import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[][] dp = new int[41][2]; // 최대 40까지 계산 가능

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[0] = new int[]{1, 0};
        dp[1] = new int[]{0, 1};

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0]; // 0이 호출된 횟수
            dp[i][1] = dp[i-1][1] + dp[i-2][1]; // 1이 호출된 횟수
        }

        int[][] returnArr = new int[n][2];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            returnArr[i] = Arrays.copyOf(dp[value], 2);
        }

        for (int[] result : returnArr) {
            System.out.println(result[0] + " " + result[1]);
        }

        br.close();
    }
}