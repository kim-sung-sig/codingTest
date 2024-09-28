import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> resultList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int[] line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = line[0];
            int y1 = line[1];
            int r1 = line[2];
            int x2 = line[3];
            int y2 = line[4];
            int r2 = line[5];

            if(x1 == x2 && y1 == y2 && r1 == r2){ // 무한인 지점
                resultList.add(-1);
                continue;
            }

            double d = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2,2));
            int sub = Math.abs(r1 - r2);


            if(r1 + r2 == d || sub == d){ // 접접이 1개인 경우 1,3
                resultList.add(1);
            } else if(r1 + r2 < d || sub > d){ // 4, 5
                resultList.add(0);
            } else {
                resultList.add(2);
            }
            
        }

        resultList.forEach(System.out::println);
    }
}