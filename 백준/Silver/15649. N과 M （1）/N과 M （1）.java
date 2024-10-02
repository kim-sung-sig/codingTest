import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        br.close();

        result = new int[m];
        dfs(0, n, m, new boolean[n]);

        bw.flush();
        bw.close();
    }

    public static void dfs(int depth, int n, int m, boolean[] visited) throws IOException {
        if(depth == m) {
            for(int i : result) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = i + 1;
                dfs(depth + 1, n, m, visited);
                visited[i] = false;
            }
        }
    }
}