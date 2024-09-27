import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        String guide = "a와 b를 비교한 결과를 출력합니다.";
        if (a-b > 0) {
            guide = ">";
        } else if (a - b < 0) {
            guide = "<";
        } else {
            guide = "==";
        }
        System.out.println(guide);
    }
}