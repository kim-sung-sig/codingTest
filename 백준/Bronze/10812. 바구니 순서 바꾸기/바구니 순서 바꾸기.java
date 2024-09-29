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

        for(int count = 0; count < m; count++) {
            String[] swap = br.readLine().split(" ");
            int i = Integer.parseInt(swap[0]) - 1;
            int j = Integer.parseInt(swap[1]) - 1;
            int k = Integer.parseInt(swap[2]) - 1;

            int[] a = Arrays.copyOfRange(arr, 0, i);
            int[] b = Arrays.copyOfRange(arr, i, k);
            int[] c = Arrays.copyOfRange(arr, k, j + 1);
            int[] d = Arrays.copyOfRange(arr, j + 1, arr.length);

            arr = IntStream.concat(IntStream.concat(IntStream.concat(IntStream.of(a), IntStream.of(c)), IntStream.of(b)), IntStream.of(d)).toArray();
        }

        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

}