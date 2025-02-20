import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] result = new int[3];

        result[0] += num / 300;
        num %= 300;

        result[1] += num / 60;
        num %= 60;

        result[2] += num / 10;
        num %= 10;

        if (num != 0) {
            System.out.println(-1);
        } else {
            System.out.println(result[0] + " " + result[1] + " " + result[2]);
        }

    }

}
