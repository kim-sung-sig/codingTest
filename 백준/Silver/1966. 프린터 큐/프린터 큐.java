import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] answers = new int[t];

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            Queue<Document> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int j = 0; j < n; j++) {
                int priority = Integer.parseInt(st.nextToken());

                q.add(new Document(j, priority));
                pq.add(priority);
            }

            int count = 0;
            while (!q.isEmpty()) {
                Document current = q.poll();
                if (current.priority == pq.peek()) {
                    count++;
                    pq.poll();

                    if (current.index == m) {
                        answers[i] = count;
                        break;
                    }

                } else {
                    q.add(current); // 뒤로 보냄
                }
            }
        }
        br.close();

        for (int answer : answers) {
            System.out.println(answer);
        }
    }

    static class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

}