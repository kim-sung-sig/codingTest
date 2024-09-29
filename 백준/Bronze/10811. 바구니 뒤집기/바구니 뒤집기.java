import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] arr = IntStream.rangeClosed(1, n).toArray();

        for(int i = 0; i < m; i++) {
            String[] swap = br.readLine().split(" ");
            int a = Integer.parseInt(swap[0]);
            int b = Integer.parseInt(swap[1]);
            // a~b 역순 뒤집기
            int[] tempArr = Arrays.copyOfRange(arr, a-1, b);
            for(int j = a - 1; j < b; j++) {
                arr[j] = tempArr[b - j - 1];
            }
        }

        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

}