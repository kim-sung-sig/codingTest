import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[][] map;
    static int[][] dp;

    // bottom-up 방식으로 풀이
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < i + 1; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }

            dp[N - 1] = Arrays.copyOf(map[N - 1], N);

            for(int i = N - 2; i >= 0; i--) {
                for(int j = 0; j < i + 1; j++) {
                    int curMax = dp[i + 1][j] > dp[i + 1][j + 1] ? dp[i + 1][j] : dp[i + 1][j + 1];
                    dp[i][j] = curMax + map[i][j];
                }
            }

            // System.out.println(Arrays.deepToString(dp));
            System.out.println(dp[0][0]);
        }
    }

    // 메모리 초과로 실패
    /*
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < i + 1; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }

            bfs(0, 0);

            // System.out.println(Arrays.deepToString(dp));
            IntStream.of(dp[N - 1]).max().ifPresent(System.out::println);
        }

    }

    static void bfs(int x, int y) {
        dp[0][0] = map[0][0];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            if (currentX + 1 < N) {
                dp[currentX + 1][currentY] = Math.max(dp[currentX + 1][currentY], dp[currentX][currentY] + map[currentX + 1][currentY]);
                queue.offer(new int[]{currentX + 1, currentY});
                // System.out.println("1. " + Arrays.deepToString(dp));

                dp[currentX + 1][currentY + 1] = Math.max(dp[currentX + 1][currentY + 1], dp[currentX][currentY] + map[currentX + 1][currentY + 1]);
                queue.offer(new int[]{currentX + 1, currentY + 1});
                // System.out.println("2. " + Arrays.deepToString(dp));
            }
        }

    }
     */

}