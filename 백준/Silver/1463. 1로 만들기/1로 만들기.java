import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static BufferedReader br;
    static int a = Integer.MAX_VALUE;
    static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        if(n == 1) {
            System.out.println(0);
            return;
        }

        solve(n, 0);

        System.out.println(a);
    }

    // 흠 재귀긴 재귀인데.. 이게 탐색 해야돼.. 최소 연산으로 1로 만들기
    private static void solve(int n, int count) {
        if(n == 1) {
            a = Math.min(a, count);
            return;
        }

        if (memo.containsKey(n) && memo.get(n) <= count) {
            return;
        }
        memo.put(n, count);  // 현재 n에 대한 최소 연산 횟수 저장

        if(n % 3 == 0) {
            solve(n / 3, count + 1);
        }
        if(n % 2 == 0) {
            solve(n / 2, count + 1);
        }
        solve(n - 1, count + 1);

    }

}