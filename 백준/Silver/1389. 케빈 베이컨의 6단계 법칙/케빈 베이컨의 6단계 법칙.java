import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        br.close();

        int[] result = new int[N + 1]; // 케빈 베이컨 수를 담을 배열
        for (int i = 1; i < N + 1; i++) {

            int[] dist = new int[N + 1];
            Arrays.fill(dist, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            dist[i] = 0;

            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (dist[next] == -1) {
                        dist[next] = dist[cur] + 1;
                        queue.add(next);
                    }
                }
            }

            int sum = 0;
            for (int j = 1; j < N + 1; j++) sum += dist[j];
            result[i] = sum;
        }

        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 1; i < N + 1; i++) {
            if (result[i] < min) {
                min = result[i];
                minIndex = i;
            }
        }

        System.out.println(minIndex);
    }

}