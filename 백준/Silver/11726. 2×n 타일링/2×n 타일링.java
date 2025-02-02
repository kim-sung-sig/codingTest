import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            dp = new int[N + 1];

            System.out.println(fibo(N));
        }
    }

    static int fibo(int n) {
        /*
         * f(n) = f(n-1) + f(n-2)
         * f(1) = 1, f(2) = 2
         */
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (dp[n] != 0) return dp[n];

        return dp[n] = (fibo(n - 1) + fibo(n - 2)) % 10007;
    }

}