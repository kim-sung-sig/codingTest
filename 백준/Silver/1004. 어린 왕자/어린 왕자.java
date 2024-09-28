import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        int[] result = new int[t]; // 결과를 저장할 배열

        for (int i = 0; i < t; i++) {

            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = arr[0], y1 = arr[1], x2 = arr[2], y2 = arr[3];

            int n = Integer.parseInt(br.readLine()); // 원의 개수

            for(int j = 0; j < n; j++) {
                int[] circle = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int cx = circle[0], cy = circle[1], r = circle[2];

                long d1 = (x1 - cx) * (x1 - cx) + (y1 - cy) * (y1 - cy);
                long d2 = (x2 - cx) * (x2 - cx) + (y2 - cy) * (y2 - cy);
                long r2 = r * r;

                if((r2 - d1) * (r2 - d2) < 0){ // 오버플로우 발생..
                    result[i]++;
                }
            }

        }
        br.close();

        for(int i = 0; i < t; i++) {
            System.out.println(result[i]);
        }

    }

}