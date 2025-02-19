import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T];

        int i = 0;
        while(i < T) {
            int n = Integer.parseInt(br.readLine());

            int[][] map = new int[2][n];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][n];
            dp[0][0] = map[0][0];
            dp[1][0] = map[1][0];
            if (n > 1) {
                dp[0][1] = dp[1][0] + map[0][1];
                dp[1][1] = dp[0][0] + map[1][1];
            }

            for (int j = 2; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + map[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + map[1][j];
            }

            result[i] = Math.max(dp[0][n - 1], dp[1][n - 1]);
            i++;

        }

        for(int val : result) System.out.println(val);
    }

}
