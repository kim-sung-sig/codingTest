import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> result = new LinkedHashSet<>();
        Set<String> 듣도못한사람들 = new HashSet<>(n);
        for (int i = 0; i < n; i++) 듣도못한사람들.add(br.readLine());
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (듣도못한사람들.contains(name)) result.add(name);
        };
        br.close();

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        result.stream().sorted().forEach(i -> sb.append(i).append("\n"));

        System.out.println(sb);
    }

}