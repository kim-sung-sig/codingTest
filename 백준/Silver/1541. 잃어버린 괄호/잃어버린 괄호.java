import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] split = input.split("-");

        int result = sum(split[0]);

        for (int i = 1; i < split.length; i++) {
            result -= sum(split[i]);
        }

        System.out.println(result);
    }

    static int sum(String input) {
        return Arrays.stream(input.split("\\+")).mapToInt(Integer::parseInt).sum();
    }

}