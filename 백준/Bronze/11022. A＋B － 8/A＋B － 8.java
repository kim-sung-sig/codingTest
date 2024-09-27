import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String[] result = new String[n];
        for(int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            result[i-1] = "Case #" + i + ": " + a + " + " + b + " = " + (a + b);
        }

        for(String s : result) {
            System.out.println(s);
        }
    }

}