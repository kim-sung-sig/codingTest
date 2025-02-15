import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Set<Integer>> map = new HashMap<>();
        boolean[][] graph = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    graph[i][j] = true;
                    map.computeIfAbsent(i, k -> new HashSet<>()).add(j); // i번째가 j로 직접 바로 도달가능한 노드를 저장
                }
            }
        }

        // i 번째가 도달가능한 노드들을 찾아서 저장
        for (int i = 0; i < N; i++) {
            Set<Integer> nextNodes = map.get(i);
            if (nextNodes == null) continue;

            Queue<Integer> queue = new LinkedList<>(nextNodes);
            boolean[] visited = new boolean[N];
            while (!queue.isEmpty()) {
                int node = queue.poll();
                if (visited[node]) continue;
                graph[i][node] = true;

                visited[node] = true;

                Set<Integer> next = map.get(node);
                if (next == null) continue;

                for (int n : next) {
                    map.get(i).add(n);
                    queue.add(n);
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(graph[i][j] ? "1 " : "0 ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

}
