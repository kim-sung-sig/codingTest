import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        int max = 0;
        Map<String, Integer> countMap = new HashMap<>();
        for(String str : input.split("")) {
            String upperStr = str.toUpperCase();
            countMap.merge(upperStr, 1, Integer::sum);
            max = Integer.max(max, countMap.getOrDefault(upperStr, 0));
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() == max) {
                if(sb.length() > 0) {
                    sb.setLength(0);
                    sb.append("?");
                    break;
                }
                sb.append(entry.getKey().toUpperCase());
            }
        }
        System.out.println(sb.toString());
    }

}