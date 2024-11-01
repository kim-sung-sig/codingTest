import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // System.out.println(Arrays.deepToString(arr));

        int k = Integer.parseInt(br.readLine());
        long[] result = new long[k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            long sum = 0;
            for (int j = x1 - 1; j < x2; j++) {
                for (int l = y1 - 1; l < y2; l++) {
                    sum += arr[j][l];
                }
            }
            result[i] = sum;
        }

        for (long l : result) {
            System.out.println(l);
        }

    }
}