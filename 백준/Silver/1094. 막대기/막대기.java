import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        int[] arr = {64, 32, 16, 8, 4, 2, 1};
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (a >= arr[i]) {
                a -= arr[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}