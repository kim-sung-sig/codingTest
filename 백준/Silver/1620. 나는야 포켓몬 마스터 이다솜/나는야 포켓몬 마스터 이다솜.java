import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> numToName = new HashMap<>();
        Map<String, Integer> nameToNum = new HashMap<>();
        int cnt = 1;
        while (n-- > 0) {
            String name = br.readLine();
            numToName.put(cnt, name);
            nameToNum.put(name, cnt);
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String input = br.readLine();
            if (input.charAt(0) >= 'A' && input.charAt(0) <= 'Z') sb.append(nameToNum.get(input)).append("\n");
            else sb.append(numToName.get(Integer.parseInt(input))).append("\n");
        }
        System.out.println(sb);
    }

}