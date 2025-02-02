import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        int[] calculate = new int[4];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) calculate[i] = Integer.parseInt(st.nextToken());
        br.close();

        dfs(numbers, calculate, 1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }


    static void dfs(int[] numbers, int[] calculate, int idx, int value) {
        if (idx == numbers.length) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (calculate[i] > 0) {
                calculate[i]--;
                int calculateValue = numbers[idx];
                int tempValue = value;
                if (i == 0) tempValue += calculateValue;
                else if (i == 1) tempValue -= calculateValue;
                else if (i == 2) tempValue *= calculateValue;
                else tempValue /= calculateValue;

                dfs(numbers, calculate, idx + 1, tempValue);
                calculate[i]++;
            }
        }
    }
}