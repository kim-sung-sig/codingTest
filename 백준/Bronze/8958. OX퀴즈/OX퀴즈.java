import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 로직
        int[] scores = new int[n];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            int score = 0;
            int temp = 0;

            for(String s : str.split("")) {
                if(s.equals("O")) {
                    score += ++temp;
                } else {
                    temp = 0;
                }
            }
            scores[i] = score;
        }
        br.close();

        // 출력
        for(int score : scores) {
            System.out.println(score);
        }

    }

}