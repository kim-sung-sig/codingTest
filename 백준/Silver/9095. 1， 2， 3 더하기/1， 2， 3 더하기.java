import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] arr = new int[t];
        int[] dp;
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new int[n + 1];
            
            // 로직 시작!
            if(n <= 3) {
                arr[i] = n == 1 ? 1 : n == 2 ? 2 : 4;
                continue;
            }

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;


            for(int j = 4; j <= n; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }

            arr[i] = dp[n];
        }

        for(int i = 0; i < t; i++) {
            System.out.println(arr[i]);
        }
    }

}