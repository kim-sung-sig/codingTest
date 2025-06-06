import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n > 1) dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] // 1x1 타일을 놓는 경우
                    + 2 * dp[i - 2] // 2x1,2x1 + 2x2 타일을 놓는 경우
            ) % 10007; // 나머지 연산
        }

        System.out.println(dp[n]);
    }
}