import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] result = new int[t];
        for(int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            result[i] = getPeople(k, n);
        }

        for(int i : result) {
            System.out.println(i);
        }
    }

    public static int getPeople(int k, int n) {
        if(k == 0) {
            return n;
        } else {
            int sum = 0;
            for(int i = 1; i <= n; i++) {
                sum += getPeople(k - 1, i);
            }
            return sum;
        }
    }

}