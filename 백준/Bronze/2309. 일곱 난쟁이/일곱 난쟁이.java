import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] length = br.lines().limit(9).mapToInt(Integer::parseInt).toArray();

        int total = Arrays.stream(length).sum();
        int[] exclude = new int[2];

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int sum = total - length[i] - length[j];
                if (sum == 100) {
                    exclude[0] = i;
                    exclude[1] = j;
                    break;
                }
            }
        }

        int[] result = new int[7];
        int c = 0;
        for (int i = 0; i < 9; i++) {
            if (i == exclude[0] || i == exclude[1]) continue;
            result[c++] = length[i];
        }

        Arrays.sort(result);
        for (int i : result) System.out.println(i);
    }

}