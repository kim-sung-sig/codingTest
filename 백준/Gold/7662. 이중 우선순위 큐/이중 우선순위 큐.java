import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
            int t = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for(int i = 0; i < t; i++) {
                String[] input = br.readLine().split(" ");
                String cmd = input[0];

                if (cmd.equals("I")) {
                    int num = Integer.parseInt(input[1]);
                    treeMap.compute(num, (k, v) -> v == null ? 1 : v + 1);
                }
                else if (cmd.equals("D")) {
                    if (treeMap.isEmpty()) continue;

                    if (input[1].equals("1")) {
                        int max = treeMap.lastKey();
                        if (treeMap.get(max) == 1) treeMap.pollLastEntry();
                        else treeMap.put(max, treeMap.get(max) - 1);
                    }
                    else {
                        int min = treeMap.firstKey();
                        if (treeMap.get(min) == 1) treeMap.pollFirstEntry();
                        else treeMap.put(min, treeMap.get(min) - 1);
                    }
                }
            }

            if (treeMap.isEmpty()) sb.append("EMPTY").append("\n");
            else {
                int max = treeMap.lastKey();
                int min = treeMap.firstKey();
                sb.append(max  + " " + min).append("\n");
            }
        }
        System.out.println(sb);
    }

}