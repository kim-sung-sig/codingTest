import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int count = 0;
    static boolean[] col, diag1, diag2; // 열, 왼아래대각, 오아래대각

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        col = new boolean[N];
        diag1 = new boolean[2 * N];
        diag2 = new boolean[2 * N];

        dfs(0);

        System.out.println(count);
    }

    static void dfs(int rows) {
        if (rows == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (col[i] || diag1[rows + i] || diag2[rows - i + N - 1]) continue;

            col[i] = diag1[rows + i] = diag2[rows - i + N - 1] = true; // 방문 체크
            dfs(rows + 1);
            col[i] = diag1[rows + i] = diag2[rows - i + N - 1] = false; // 빽트래킹
        }
    }

}