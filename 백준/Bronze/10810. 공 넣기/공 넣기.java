import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        // 결과 변수
        int[] result = new int[n];

        // 작업 실행
        for(int p = 0; p < m; p++) {
            String[] ijk = br.readLine().split(" ");
            int i = Integer.parseInt(ijk[0]);
            int j = Integer.parseInt(ijk[1]);
            int k = Integer.parseInt(ijk[2]);

            for(int q = i-1; q < j; q++) {
                result[q] = k;
            }

        }

        // 리턴
        String resultStr = Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(resultStr);
    }

}