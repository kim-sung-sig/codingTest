import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[10000];

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            Arrays.fill(visited, false);
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(num, ""));

            while (!q.isEmpty()) {
                Node node = q.poll();
                int n = node.num;
                String command = node.command;

                if (n == target) {
                    sb.append(command).append("\n");
                    break;
                }

                int d = (2 * n) % 10000;
                int s = n == 0 ? 9999 : n - 1;
                int l = (n % 1000) * 10 + n / 1000;
                int r = (n % 10) * 1000 + n / 10;

                if (!visited[d]) {
                    visited[d] = true;
                    q.offer(new Node(d, command + "D"));
                }

                if (!visited[s]) {
                    visited[s] = true;
                    q.offer(new Node(s, command + "S"));
                }

                if (!visited[l]) {
                    visited[l] = true;
                    q.offer(new Node(l, command + "L"));
                }

                if (!visited[r]) {
                    visited[r] = true;
                    q.offer(new Node(r, command + "R"));
                }
            }
        }

        System.out.println(sb);
    }

    static class Node {
        int num;
        String command;

        public Node(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }

}
