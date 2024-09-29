import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] result = new String[n];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            String str = input[1];

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < str.length(); j++) {
                for(int k = 0; k < r; k++) {
                    sb.append(str.charAt(j));
                }
            }
            result[i] = sb.toString();
        }
        br.close();

        for(String s : result) {
            System.out.println(s);
        }
    }

}