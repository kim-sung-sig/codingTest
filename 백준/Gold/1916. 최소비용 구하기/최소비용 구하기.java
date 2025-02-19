import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Bus>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Bus(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int result = dijkstra(n, graph, start, end);
        System.out.println(result);
    }

    static int dijkstra(int n, List<Bus>[] graph, int start, int end) {
        PriorityQueue<Bus> pq = new PriorityQueue<>(); // 캬 이걸 여기서 캬.. 개쩐다..
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        pq.add(new Bus(start, 0));

        while (!pq.isEmpty()) {
            Bus cur = pq.poll();
            int now = cur.node;
            int nowCost = cur.cost;

            if (nowCost > dist[now]) continue;

            for (Bus next : graph[now]) {
                int nextNode = next.node;
                int nextCost = nowCost + next.cost;

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.add(new Bus(nextNode, nextCost));
                }
            }
        }

        return dist[end]; // 최소 비용 반환
    }

}

class Bus implements Comparable<Bus> {
    int node;
    int cost;

    public Bus(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Bus o) {
        return this.cost - o.cost;
    }

}
