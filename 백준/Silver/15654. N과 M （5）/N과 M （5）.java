import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, 1, arr[i] + " ");
            visited[i] = false;
        }

        System.out.println(sb);
    }

    static void dfs(int idx, int depth, String str) {
        if (depth == m) {
            sb.append(str).append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && idx != i) {
                visited[i] = true;
                dfs(i, depth + 1, str + arr[i] + " ");
                visited[i] = false;
            }
        }
    }

}
