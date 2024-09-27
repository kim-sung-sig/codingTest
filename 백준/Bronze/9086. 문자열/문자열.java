import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str;
        String[] result = new String[n];
        for(int i = 0; i < n; i++) {
            str = br.readLine();
            result[i] = (str.charAt(0) + "") + (str.charAt(str.length() - 1) + "");
        }

        for(int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }

}