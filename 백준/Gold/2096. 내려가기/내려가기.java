import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int[][] minDp = new int[n + 1][3];
        int[][] maxDp = new int[n + 1][3];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (i == 1) {
                minDp[i][0] = maxDp[i][0] = a;
                minDp[i][1] = maxDp[i][1] = b;
                minDp[i][2] = maxDp[i][2] = c;
                continue;
            }

            minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + a;
            maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + a;

            minDp[i][1] = Math.min(minDp[i - 1][0], Math.min(minDp[i - 1][1], minDp[i - 1][2])) + b;
            maxDp[i][1] = Math.max(maxDp[i - 1][0], Math.max(maxDp[i - 1][1], maxDp[i - 1][2])) + b;

            minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + c;
            maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + c;
        }

        int max = Math.max(maxDp[n][0], Math.max(maxDp[n][1], maxDp[n][2]));
        int min = Math.min(minDp[n][0], Math.min(minDp[n][1], minDp[n][2]));
        System.out.println(max + " " + min);
    }

}
