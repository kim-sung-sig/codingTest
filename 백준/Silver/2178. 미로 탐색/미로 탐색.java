import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int cnt = Integer.MAX_VALUE;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            int[] tempArr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            arr[i] = tempArr;
        }

        // dfs(0, 0, arr, 1, new boolean[N][M]);
        cnt = bfs(arr, N, M);

        System.out.println(cnt);
    }

    private static int bfs(int[][] arr, int N, int M) {
        int[][] visited = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1});
        visited[0][0] = 1;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            if(x == N - 1 && y == M - 1) {
                return count; // 아마 가장 짧은게 가장먼저 리턴하여 끝날것이다.
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if(arr[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    q.add(new int[] {nx, ny, count + 1});
                }
            }
        }

        return -1; // 도착하지 못했을때
    }

    // private static void dfs(int x, int y, int[][] arr, int count, boolean[][] visited) {
    //     if(x == arr.length - 1 && y == arr[0].length - 1) { // 목적지에 도착했을때
    //         cnt = Math.min(count, cnt);
    //         return;
    //     }

    //     for(int i = 0; i < 4; i++) {
    //         int nx = x + dx[i];
    //         int ny = y + dy[i];

    //         if(nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length) {
    //             continue;
    //         }

    //         if(arr[nx][ny] == 1 && !visited[nx][ny]) {
    //             visited[nx][ny] = true;
    //             dfs(nx, ny, arr, count + 1, visited);
    //             visited[nx][ny] = false;
    //         }

    //     }
    // }
}
