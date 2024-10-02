import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // n! 에서 뒤에 0의 갯수는
        // 2^r * 5^r 인 경우에 r개 생긴다.
        // n 번째 5의 배수 와 n + 1 번째 5의 배수 사이에는 반드시 1개 이상의 짝수가 존재 하므로
        // 5의 배수의 갯수를 세면 된다.
        int count = 0;
        while(n > 0) {
            count += n / 5;
            n /= 5;
        }

        System.out.println(count);
    }

}