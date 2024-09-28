import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int result = 0;
        if(n < 100) { // 100 이하인 경우 모두 성립 한다.
            result = n;
        } else if (n <= 1000) { // 100 이상 1000 미만인 경우 ( 1000 일때 아래는 원래 맞지 않지만 1000은 등차수열이 아니므로 999 한것과 동일)
            result = 99;
            for(int i = 100; i <= n; i++) {
                int a = i / 100;        // 100의 자리
                int b = (i / 10) % 10;  // 10의 자리
                int c = i % 10;         // 1의 자리

                if(a + c == 2 * b) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

}