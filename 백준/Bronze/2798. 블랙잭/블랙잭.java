import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.close();

        int sum = -1;
        for (int i = 0; i < N - 2; i++) {

            if(arr[i] >= M) continue; // skip

            for (int j = i + 1; j < N - 1; j++) {

                if(arr[i] + arr[j] >= M) continue; // skip

                for (int k = j + 1; k < N; k++) {
                    int tempSum = arr[i] + arr[j] + arr[k];

                    if (tempSum <= M && tempSum > sum) {
                        sum = tempSum;
                    }
                }
            }
        }

        System.out.println(sum);
    }

}