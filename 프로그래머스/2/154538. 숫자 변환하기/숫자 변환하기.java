import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int x, int y, int n) {
        if (x == y) return 0;

        int[] dp = new int[y+1];
        final int MAX = 1_000_001;
        Arrays.fill(dp, MAX);
        dp[x] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(x);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int val : new int[]{cur + n, cur * 2, cur * 3}) {
                if (val > y) continue;

                if(dp[val] > dp[cur] + 1) {
                    dp[val] = dp[cur] + 1;
                    q.offer(val);
                }
            }
        }

        return dp[y] == MAX ? -1 : dp[y];
    }

}