import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        while(N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {

                if (pq.isEmpty()) sb.append(0);
                else {
                    int absVal = pq.poll();
                    Integer minusVal = map.get(-1 * absVal);

                    if (minusVal != null) {
                        sb.append(-1 * absVal);
                        if (minusVal > 1) map.put(-1 * absVal, minusVal - 1);
                        else map.remove(-1 * absVal);
                    }
                    else {
                        Integer plusVal = map.get(absVal);
                        sb.append(absVal);
                        if (plusVal > 1) map.put(absVal, plusVal - 1);
                        else map.remove(absVal);
                    }

                }

                sb.append('\n');
            }
            else {
                pq.offer(Math.abs(x));
                map.compute(x, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        System.out.println(sb);
    }

}
