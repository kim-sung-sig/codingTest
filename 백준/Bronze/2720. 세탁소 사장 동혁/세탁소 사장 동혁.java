import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 결과 변수
        int[][] result = new int[n][4];

        // 로직
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());

            int quater = a / 25;
            int dime = (a % 25) / 10;
            int nickel = ((a % 25) % 10) / 5;
            int penny = ((a % 25) % 10) % 5;
            result[i] = new int[]{quater, dime, nickel, penny};
        }
        
        // 출력
        for(int i = 0; i < n; i++) {
            System.out.println(Arrays.stream(result[i]).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }
    }

}