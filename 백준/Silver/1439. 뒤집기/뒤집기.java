import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("");

        String first = input[0];
        int change = 0;

        for (int i = 1; i < input.length; i++) {
            if (!first.equals(input[i])) {
                change++;
                first = input[i];
            }
        }

        System.out.println((change + 1) / 2);

    }

}