import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = n;
        br.close();

        int count = 0;
        while(true) {
            int q = num / 10;
            int r = num % 10;
            int c = (q + r) % 10;
            num = (r*10) + c;

            count++;
            if(num == n) {
                break;
            }
        }
        System.out.println(count);
    }

}