import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int sum = n*(n+1) / 2;
        System.out.println(sum);
    }

}