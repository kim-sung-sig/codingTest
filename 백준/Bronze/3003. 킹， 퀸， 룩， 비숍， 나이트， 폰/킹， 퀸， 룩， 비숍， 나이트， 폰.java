import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] target = new int[] {1, 1, 2, 2, 2, 8};

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            result.add(target[i] - input[i]);
        }

        String str = result.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(str);

    }

}