import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] copy = arr.clone();
        Arrays.sort(copy);

        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(copy).forEach(num -> {
            if (!map.containsKey(num)) map.put(num, map.size());
        });

        for (int num : arr) bw.write(map.get(num) + " ");
        bw.flush();
        bw.close();
        br.close();
    }

}