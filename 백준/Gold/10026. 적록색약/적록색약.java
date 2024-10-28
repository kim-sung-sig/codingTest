import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][n];
        String[][] arr2 = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            arr[i] = temp;
            for (int j = 0; j < n; j++) {
                arr2[i][j] = temp[j].equals("G") ? "R" : temp[j];
            }
        }
        br.close();

        int a = calc(arr, new boolean[n][n]);
        int b = calc(arr2, new boolean[n][n]);

        System.out.println(a + " " + b);
    }

    private static int calc(String[][] arr, boolean[][] visited) {
        int cnt = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(arr, visited, i, j, arr[i][j]);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void dfs(String[][] arr, boolean[][] visited, int x, int y, String color) {
        visited[x][y] = true;

        int n = arr.length;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue; // 영역 벗어남
            if (visited[nx][ny]) continue; // 이미 방문한 곳
            if (!arr[nx][ny].equals(color)) continue; // 색상이 다름

            dfs(arr, visited, nx, ny, color); // 재귀 호출
        }
    }
}