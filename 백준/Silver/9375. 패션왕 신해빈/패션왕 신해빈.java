import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> result = new ArrayList<>();
        while(n-- > 0) {
            int c = Integer.parseInt(br.readLine());

            Map<String, Set<String>> map = new HashMap<>();
            for (int i = 0; i < c; i++) {
                String[] input = br.readLine().split(" ");
                String name = input[0];
                String type = input[1];
                map.computeIfAbsent(type, k -> new HashSet<>()).add(name);
            }

            int answer = map.values().stream().mapToInt(Set::size).reduce(1, (a, b) -> a * (b + 1)) - 1;
            result.add(answer);
        }

        result.forEach(System.out::println);
    }

}