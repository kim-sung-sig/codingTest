import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> ladder = new HashMap<>();
        Map<Integer, Integer> snake = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        br.close();

        boolean[] visited = new boolean[101];
        visited[1] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.val == 100) {
                System.out.println(node.cnt);
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int next = node.val + i;
                if (next > 100) continue;

                while (true) {
                    boolean ladderFlag = ladder.containsKey(next);
                    boolean snakeFlag = snake.containsKey(next);

                    if (ladderFlag) next = ladder.get(next);
                    else if (snakeFlag) next = snake.get(next);
                    else break;
                }

                if (visited[next]) continue;
                visited[next] = true;
                q.offer(new Node(next, node.cnt + 1));
            }

        }

    }

    static class Node {
        int val;
        int cnt;

        public Node(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
}