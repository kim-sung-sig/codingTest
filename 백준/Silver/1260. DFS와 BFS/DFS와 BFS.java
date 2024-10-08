import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static int[][] graph;
    private static List<Integer> dfs = new ArrayList<>();
    private static List<Integer> bfs = new ArrayList<>();

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0], m = arr[1], v = arr[2];

        graph = new int[n][n];

        for (int i = 0; i < m; i++) {
            int[] edge = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[edge[0] - 1][edge[1] - 1] = 1;
            graph[edge[1] - 1][edge[0] - 1] = 1;
        }
        br.close();

        // System.out.println(Arrays.deepToString(graph));

        dfs.add(v);
        dfs(v, new boolean[n]);

        bfs.add(v);
        bfs(v, new boolean[n]);

        System.out.println(dfs.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(bfs.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }

    public static void dfs(int v, boolean[] visited) {
        visited[v - 1] = true;
        for (int i = 0; i < graph.length; i++) { // 옆으로 작은것 부터 돈다.
            if (graph[v - 1][i] == 1 && !visited[i]) { // 갈 수 있고 방문을 안했다면
                dfs.add(i + 1); // 방문한 노드를 넣어준다.
                dfs(i + 1, visited);
            }
        }
    }

    public static void bfs(int v, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v - 1] = true;
        while( !queue.isEmpty() ) {
            int v1 = queue.poll();

            for (int i = 0; i < graph.length; i++) {
                if (graph[v1 - 1][i] == 1 && !visited[i]) {
                    bfs.add(i + 1);
                    visited[i] = true;
                    queue.offer(i + 1);
                }
            }
        }
    }

}
