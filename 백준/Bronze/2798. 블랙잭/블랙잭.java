import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();
        for(int i = N - 1; i >= 0; i--) {
            for(int j = i - 1; j >= 0; j--) {
                for(int k = j - 1; k >= 0; k--) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum <= M) {
                        list.add(sum);
                    }
                }
            }
        }

        System.out.println(list.stream().mapToInt(Integer::intValue).max().getAsInt());
    }

}