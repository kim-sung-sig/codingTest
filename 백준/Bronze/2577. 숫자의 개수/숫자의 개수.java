import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        br.close();

        int result = a * b * c;
        String resultStr = String.valueOf(result);
        int[] count = new int[10];
        for (String str : resultStr.split("")) {
            count[Integer.parseInt(str)]++;
        }

        for (int i : count) {
            System.out.println(i);
        }
    }

}