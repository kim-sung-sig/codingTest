import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력
        int[] arr = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        br.close();

        // 정렬
        Arrays.sort(arr);

        // 출력
        for(int i = 0; i < arr.length; i++) {
            bw.write(arr[arr.length - i - 1] + "");
        }
        bw.flush();
        bw.close();
    }

}