import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인접 리스트
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = IntStream.rangeClosed(0, N)
                .mapToObj(i -> new ArrayList<>())
                .toArray(ArrayList[]::new);

        // 진입 차수
        int[] rank = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int small = Integer.parseInt(st.nextToken());
            int tall = Integer.parseInt(st.nextToken());

            graph[small].add(tall);
            rank[tall]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (rank[i] == 0) queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for (int next : graph[cur]) {
                rank[next]--;
                if (rank[next] == 0) queue.add(next);
            }
        }

        System.out.println(sb.toString().trim());
    }

    /*
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int small = Integer.parseInt(st.nextToken());
            int tall = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(tall, k -> new HashSet<>()).add(small);
            map.putIfAbsent(small, new HashSet<>());
        }

        Queue<Integer> queue = new LinkedList<>();
        map.forEach((k, v) -> {
            if (v.isEmpty()) queue.add(k);
        });

        StringBuilder sb = new StringBuilder();
        Set<Integer> visited = new HashSet<>(queue);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            map.remove(cur);

            map.forEach((k, v) -> {
                v.remove(cur);
                if (v.isEmpty() && !visited.contains(k)) {
                    queue.add(k);
                    visited.add(k);
                }
            });
        }

        System.out.println(sb.toString().trim());

    }
     */

}