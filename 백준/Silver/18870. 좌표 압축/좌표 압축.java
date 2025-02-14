import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        Map<Integer, Integer> map = new HashMap<>();
        int[] copy = arr.clone();
        Arrays.sort(copy);

        for (int copyNum : copy) if (!map.containsKey(copyNum)) map.put(copyNum, map.size());

        for (int num : arr) sb.append(map.get(num)).append(" ");
        System.out.println(sb);
    }

}