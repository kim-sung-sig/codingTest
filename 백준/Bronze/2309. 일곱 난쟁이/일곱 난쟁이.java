import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> length = new ArrayList<>();

        br.lines().limit(9).mapToInt(Integer::parseInt).forEach(length::add);

        int total = length.stream().mapToInt(Integer::valueOf).sum();

        outer:
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (total - length.get(i) - length.get(j) == 100) {
                    length.remove(j);
                    length.remove(i);
                    break outer;
                }
            }
        }

        length.stream().sorted().forEach(System.out::println);
    }

}