import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            String status = input[1];

            map.put(name, status);
        }

        // map 에서 value 가 "enter" 인 key 들을 list 에 담고 싶다면?
        List<String> list = new ArrayList<>();
        map.forEach((key, value) -> {
            if(value.equals("enter")) {
                list.add(key);
            }
        });
        list.sort(Comparator.reverseOrder());

        list.forEach(System.out::println);
    }
}