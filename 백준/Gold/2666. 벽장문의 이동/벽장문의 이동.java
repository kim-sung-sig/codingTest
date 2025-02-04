import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] request;
    static int[][][] dp;
    
    // 조낸 어려운데 골드5 맞냐?
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 벽장의 갯수

        st = new StringTokenizer(br.readLine(), " ");
        int a1 = Integer.parseInt(st.nextToken()); // 첫 번째 열려있는 벽장의 번호
        int a2 = Integer.parseInt(st.nextToken()); // 두 번째 열려있는 벽장의 번호

        M = Integer.parseInt(br.readLine()); // 이동 횟수
        request = new int[M];

        for (int i = 0; i < M; i++) request[i] = Integer.parseInt(br.readLine());

        dp = new int[N + 1][N + 1][M]; // dp[첫번째 열려있는 벽장의 번호][두번째 열려있는 벽장의 번호][request의 인덱스] = 최소 이동 횟수
        for (int[][] m1 : dp) for (int[] m2 : m1) Arrays.fill(m2, -1);

        System.out.println(dfs(a1, a2, 0));

    }

    static int dfs(int a1, int a2, int idx) {
        if (idx == M) return 0;

        if (dp[a1][a2][idx] != -1) return dp[a1][a2][idx]; // 이미 계산한 경우

        int target = request[idx]; // 이번에 열어야 할 벽장 번호

        // 벽장 1을 target으로 이동하는 경우
        int move1 = Math.abs(a1 - target) + dfs(target, a2, idx + 1);
        // 벽장 2를 target으로 이동하는 경우
        int move2 = Math.abs(a2 - target) + dfs(a1, target, idx + 1);

        // 최소 이동 횟수를 DP에 저장
        return dp[a1][a2][idx] = Math.min(move1, move2);
    }

}