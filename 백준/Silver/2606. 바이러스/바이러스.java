import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[m + 1][m + 1];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        br.close();

        boolean[] visited = new boolean[m + 1];

        System.out.println(dfs(arr, visited, 1, 0));

    }

    public static int dfs(int[][] arr, boolean[] visited, int v, int cnt) {
        visited[v] = true;

        for(int i = 1; i < arr.length; i++) {
            if(arr[v][i] == 1 && !visited[i]) {
                cnt = dfs(arr, visited, i, cnt + 1);
            }
        }

        return cnt;
    }
}