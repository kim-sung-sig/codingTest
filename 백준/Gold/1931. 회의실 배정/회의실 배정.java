import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        int[][] times = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, (t1, t2) -> {
            if (t1[1] == t2[1]) return t1[0] - t2[0];
            return t1[1] - t2[1];
        });

        int count = 0;
        int end = -1;

        for (int i = 0; i < N; i++) {
            if (times[i][0] >= end) {
                end = times[i][1];
                count++;
            }
        }

        System.out.println(count);
    }

}