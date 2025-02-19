import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] sumArr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            max = Math.max(max, sumArr[i] - sumArr[i - k]);
        }

        System.out.println(max);
    }

}