import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][4];

        for(int i = 0; i < n; i++){
            String[] str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]); // weight
            arr[i][1] = Integer.parseInt(str[1]); // height
        }
        br.close();

        int[] rank = new int[n];
        Arrays.fill(rank, 1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    rank[i]++;
                }
            }
        }

        String resultStr = Arrays.stream(rank).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(resultStr);
    }

}