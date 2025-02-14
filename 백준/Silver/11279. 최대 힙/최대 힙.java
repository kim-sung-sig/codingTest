import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.equals("0")) {
                if (pq.isEmpty()) sb.append("0");
                else sb.append(pq.poll());

                sb.append("\n");
            }
            else pq.add(Integer.parseInt(input));
        }

        System.out.println(sb);
    }

}