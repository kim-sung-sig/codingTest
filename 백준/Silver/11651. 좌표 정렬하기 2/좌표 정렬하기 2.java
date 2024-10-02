import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++){
            String[] str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]); // x
            arr[i][1] = Integer.parseInt(str[1]); // y
        }
        br.close();

        Arrays.stream(arr)
        .sorted((a, b) -> {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        })
        .forEach(v -> {
            System.out.println(v[0] + " " + v[1]);
        });;
    }

}