import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> site = new HashMap<>();
        br.lines().limit(n)
            .forEach(line -> {
                StringTokenizer st2 = new StringTokenizer(line, " ");
                String siteName = st2.nextToken();
                String password = st2.nextToken();
                site.put(siteName, password);
            });
        
        StringBuilder sb = new StringBuilder();
        br.lines().limit(m)
            .forEach(line -> sb.append(site.get(line)).append("\n"));

        System.out.println(sb);
    }

}