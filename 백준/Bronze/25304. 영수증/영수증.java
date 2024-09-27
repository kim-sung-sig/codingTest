import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 0; i < count; i++) {
            int[] costs = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sum += costs[0] * costs[1];
        }

        if(sum == price) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}