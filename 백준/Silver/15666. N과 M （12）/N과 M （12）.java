import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static Set<String> set = new LinkedHashSet<>();
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

        dfs(0, 0, "");

        set.forEach(System.out::println);
    }

    static void dfs(int idx, int depth, String str) {
        if (depth == m) {
            set.add(str.trim());
            return;
        }

        for (int i = idx; i < n; i++) {
            dfs(i, depth + 1, str + arr[i] + " ");
        }
    }

}