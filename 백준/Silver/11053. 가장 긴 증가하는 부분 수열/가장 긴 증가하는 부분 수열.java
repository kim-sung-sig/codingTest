import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static int a = Integer.MAX_VALUE;
    static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        // 가장 긴 증가하는 수열 찾기
        int[] dp = new int[n];
        dp[0] = 1;
        // System.out.println("init");
        // System.out.println(Arrays.toString(dp));
        for(int i = 1; i < n; i++) {
            dp[i] = 1;
            // System.out.println("작업실행 : " + i);
            // System.out.println(Arrays.toString(dp));
            
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    // System.out.println("증감 : " + Arrays.toString(dp));
                }
            }

            // System.out.println("작업완료 : " + i);
            // System.out.println(Arrays.toString(dp));
            // System.out.println();
        }



        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }

}
