import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100_001];
        visited[n] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.val == target) {
                System.out.println(node.cnt);
                break;
            }

            if (node.val * 2 <= 100_000 && !visited[node.val * 2]) {
                visited[node.val * 2] = true;
                q.offer(new Node(node.val * 2, node.cnt + 1));
            }
            if (node.val + 1 <= 100_000 && !visited[node.val + 1]) {
                visited[node.val + 1] = true;
                q.offer(new Node(node.val + 1, node.cnt + 1));
            }
            if (node.val - 1 >= 0 && !visited[node.val - 1]) {
                visited[node.val - 1] = true;
                q.offer(new Node(node.val - 1, node.cnt + 1));
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