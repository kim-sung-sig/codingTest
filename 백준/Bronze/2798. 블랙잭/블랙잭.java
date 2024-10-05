import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        int sum = -1;
        for(int i = N - 1; i >= 0; i--) {

            if(arr[i] >= M) continue; // skip

            for(int j = i - 1; j >= 0; j--) {

                if(arr[i] + arr[j] >= M) continue; // skip

                for(int k = j - 1; k >= 0; k--) {
                    int tempSum = arr[i] + arr[j] + arr[k];
                    if(tempSum <= M) {
                        if(tempSum == M) {
                            sum = tempSum;
                            break;
                        } else if(tempSum > sum) {
                            sum = tempSum;
                        }
                    }
                }
            }
        }

        System.out.println(sum);
    }

}