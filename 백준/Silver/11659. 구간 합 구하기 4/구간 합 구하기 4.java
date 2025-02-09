import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (i == 0) dp[i] = nums[i];
            else dp[i] = dp[i - 1] + nums[i];
        }

        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            int sum = dp[end] - dp[start] + nums[start];
            result[i] = sum;
        }

        for (int i = 0; i < m; i++) System.out.println(result[i]);
    }

}