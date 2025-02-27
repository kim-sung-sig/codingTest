import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> deque = new LinkedList<>();

        IntStream.rangeClosed(1, n).forEach(deque::add);

        while (!deque.isEmpty()) {
            int first = deque.poll();
            System.out.print(first + " ");

            if (!deque.isEmpty()) {
                int second = deque.poll();
                deque.add(second);
            }
        }

    }

}