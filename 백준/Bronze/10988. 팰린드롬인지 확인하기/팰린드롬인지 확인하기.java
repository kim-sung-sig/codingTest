import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        int flag = 1;
        for(int i = 0; i < input.length() / 2; i++) {
            if(input.charAt(i) != input.charAt(input.length() - i - 1)) {
                flag = 0;
                break;
            }
        }

        System.out.println(flag);
    }

}