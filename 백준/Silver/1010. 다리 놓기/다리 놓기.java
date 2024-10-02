import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[][] sites = new int[t][2];
        for(int i = 0; i < t; i++){
            String[] input = br.readLine().split(" ");
            sites[i][0] = Integer.parseInt(input[0]);
            sites[i][1] = Integer.parseInt(input[1]);
        }
        br.close();

        for(int i = 0; i < t; i++){
            int n = sites[i][0];
            int m = sites[i][1];
            System.out.println(nCr(m, n));
        }

    }

    // nCr = n! / r!(n-r)! (팩토리얼을 이용한 컨비네이션)
    private static int nCr(int n, int r) {
        int result = 1;
        for(int i = 0; i < r; i++){
            result *= (n-i);
            result /= (i+1);
        }
        return result;
    }


    // nCr = n-1Cr-1 + n-1Cr (dp를 이용한 컨비네이션)
    // private static int nCr(int n, int r){
    //     int[][] dp = new int[n+1][r+1];
    //     for(int i = 0; i <= n; i++){
    //         for(int j = 0; j <= Math.min(i, r); j++){
    //             if(j == 0 || j == i){
    //                 dp[i][j] = 1;
    //             }else{
    //                 dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
    //             }
    //         }
    //     }
    //     return dp[n][r];
    // }

    // nCr = n-1Cr-1 + n-1Cr (재귀를 이용한 컨비네이션 = 시간초과)
    // private static int nCr(int n, int r){
    //     if(n == r || r == 0){
    //         return 1;
    //     }
    //     return nCr(n-1, r-1) + nCr(n-1, r);
    // }

}
