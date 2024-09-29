import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        br.close();

        if(n == 0){
            System.out.println("0");
            return ;
        }

        StringBuffer sb = new StringBuffer();
        while(n > 0){
            int temp = n % b;
            sb.append(temp < 10 ? temp : Character.toString((char)(temp + 55)));
            n /= b;
        }

        System.out.println(sb.reverse().toString());
    }
}