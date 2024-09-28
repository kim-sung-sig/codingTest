import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Map<String, Integer> scoreMap = new HashMap<>();
        scoreMap.put("A+", 9);
        scoreMap.put("A0", 8);
        scoreMap.put("B+", 7);
        scoreMap.put("B0", 6);
        scoreMap.put("C+", 5);
        scoreMap.put("C0", 4);
        scoreMap.put("D+", 3);
        scoreMap.put("D0", 2);
        scoreMap.put("F", 0);

        double totalHagJum = 0;
        double totalScore = 0;

        for(int i = 0; i < 20; i++) {
            String[] input = br.readLine().split(" ");
            double hagJum = Double.parseDouble(input[1]);
            String score = input[2];

            if(score.equals("P")) {
                continue;
            }

            totalHagJum += hagJum;
            totalScore += scoreMap.get(score) * hagJum;
        }
        br.close();

        System.out.println(String.format("%.6f", (totalScore/2) / totalHagJum));
    }

}