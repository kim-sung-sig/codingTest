import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        int max = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) {
            // 0. ㅁ
            if (i + 1 < n && j + 1 < m) {
                int sum = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1];
                max = Math.max(max, sum);
            }

            // 1. ㅣ
            if (i + 3 < n) {
                int sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j];
                max = Math.max(max, sum);
            }

            // 1. ㅡ
            if (j + 3 < m) {
                int sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3];
                max = Math.max(max, sum);
            }


            // 2. ㅜ & ㅗ
            if (i + 1 < n && j + 2 < m) {
                int ㅜ = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 1];
                max = Math.max(max, ㅜ);

                int ㅗ = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
                max = Math.max(max, ㅗ);
            }

            // 2. ㅏ & ㅓ
            if (i + 2 < n && j + 1 < m) {
                int ㅏ = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j];
                max = Math.max(max, ㅏ);

                int ㅓ = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
                max = Math.max(max, ㅓ);
            }

            // 3. (<->) ㄱ & ㄴ (가로가 긴)
            if (i + 1 < n && j + 2 < m) {
                int ㄱ = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 2];
                max = Math.max(max, ㄱ);

                int ㄱ_ = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j];
                max = Math.max(max, ㄱ_);

                int ㄴ = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
                max = Math.max(max, ㄴ);

                int ㄴ_ = map[i][j + 2] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
                max = Math.max(max, ㄴ_);
            }

            // 3. (ㅡ|) ㄱ & ㄴ(세로가 긴)
            if (i + 2 < n && j + 1 < m) {
                int ㄱ = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
                max = Math.max(max, ㄱ);

                int ㄱ_ = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 2][j];
                max = Math.max(max, ㄱ_);

                int ㄴ = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1];
                max = Math.max(max, ㄴ);

                int ㄴ_ = map[i + 2][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
                max = Math.max(max, ㄴ_);
            }

            // 4. ㄹ 2 * 3
            if (i + 1 < n && j + 2 < m) {
                int ㄹ = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2];
                max = Math.max(max, ㄹ);

                int ㄹ_ = map[i + 1][j] + map[i + 1][j + 1] + map[i][j + 1] + map[i][j + 2];
                max = Math.max(max, ㄹ_);
            }

            // 4. ㄹ 3 * 2
            if (i + 2 < n && j + 1 < m) {
                int ㄹ = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
                max = Math.max(max, ㄹ);

                int ㄹ_ = map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j] + map[i + 2][j];
                max = Math.max(max, ㄹ_);
            }

        }

        System.out.println(max);
    }

}
