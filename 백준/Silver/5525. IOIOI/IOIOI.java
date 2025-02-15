import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String S = br.readLine();

        int count = 0;
        int patternCount = 0;
        int i = 1;

        while (i++ < M - 1) {
            if (S.charAt(i - 2) == 'I' && S.charAt(i - 1) == 'O' && S.charAt(i) == 'I') {
                patternCount++;
                if (patternCount >= N) count++;
                i++;
            }
            else patternCount = 0;
        }

        System.out.println(count);
    }

}