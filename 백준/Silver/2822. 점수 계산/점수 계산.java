import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[8];
        for (int i = 0; i < 8; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        // 순서를 저장
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            map.put(input[i], i + 1);
        }

        // 상위값으로 정렬
        Arrays.sort(input);

        int[] top = Arrays.stream(input)
                .sorted()
                .skip(3)
                .toArray();

        int sum = 0;
        int[] order = new int[5];
        for (int i = 0; i < 5; i++) {
            sum += top[i];
            order[i] = map.get(top[i]);
        }
        Arrays.sort(order);

        System.out.println(sum);
        System.out.println(Arrays.toString(order).replaceAll("[\\[\\],]", ""));
    }

}