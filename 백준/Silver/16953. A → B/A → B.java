import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<V> q = new LinkedList<>();
        q.offer(new V(a, 1));

        long result = -1;
        while (!q.isEmpty()) {
            V cur = q.poll();
            long num = cur.num;
            long cnt = cur.cnt;

            if (num == b) {
                result = cnt;
                break;
            }

            if (num * 2 <= b) {
                q.offer(new V(num * 2, cnt + 1));
            }

            if (num * 10 + 1 <= b) {
                q.offer(new V(num * 10 + 1, cnt + 1));
            }

        }

        System.out.println(result);
    }

    static class V {
        long num;
        long cnt;

        public V(long num, long cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

}