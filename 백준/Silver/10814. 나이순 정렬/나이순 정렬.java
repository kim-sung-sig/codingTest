import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력
        int n = Integer.parseInt(br.readLine());
        
        String[][] arr = new String[n][3];
        for(int i = 0; i < n; i++) {
            // arr[i] = Stream.concat(Arrays.stream(br.readLine().split(" ")), Arrays.stream(new String[] {i + ""})).toArray(String[]::new);
            // 스트림이 가독성을 떨어트리는 느낌이라서 아래와 같이 변경
            String[] input = br.readLine().split(" ");
            arr[i][0] = input[0];
            arr[i][1] = input[1];
            arr[i][2] = String.valueOf(i);
        }
        br.close();

        // 정렬
        Arrays.sort(arr, (a, b) -> {
            if(Integer.parseInt(a[0]) == Integer.parseInt(b[0])) {
                return Integer.parseInt(a[2]) - Integer.parseInt(b[2]);
            }
            return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
        });

        // 출력
        for(int i = 0; i < arr.length; i++) {
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }
        bw.flush();
        bw.close();
    }

}
