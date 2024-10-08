import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine().split(" ")[1]);

        List<Integer> list = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        String result = list.stream()
                .filter(i -> i < x)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        
        System.out.println(result);
    }

}