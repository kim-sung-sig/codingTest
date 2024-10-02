import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr); // 이진 탐색을 위한 정렬

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String str = IntStream.range(0, m)
                .mapToObj(i -> {
                    int result = Arrays.binarySearch(arr, arr2[i]); // 이진 탐색
                    return result >= 0 ? "1" : "0";
                })
                .collect(Collectors.joining(" "));
        System.out.println(str);
    }

}