import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Long> list = new ArrayList<>(Arrays.asList(0L, 1L, 1L, 1L, 2L, 2L, 3L, 4L, 5L, 7L, 9L));

        long[] result = new long[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num < list.size()) result[i] = list.get(num);
            else {
                for (int j = list.size(); j <= num; j++) list.add(list.get(j - 1) + list.get(j - 5));
                result[i] = list.get(num);
            }
        }

        for (int i = 0; i < n; i++) System.out.println(result[i]);
    }

}