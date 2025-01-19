import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[] dp;   // memoization
    int d;      // n
    int goal;   // target

    public int solution(int x, int y, int n) {
        if (x == y) return 0;

        dp = new int[y+1];
        goal = y;
        d = n;
        dp[x] = 0;

        // int answer = solveDfsWrapper(x);
        int answer = solveBfs(x);

        return answer;
    }

    int solveBfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int val : new int[]{cur + d, cur * 2, cur * 3}) {
                if (val > goal) continue;

                if(dp[val] > dp[cur] + 1) {
                    dp[val] = dp[cur] + 1;
                    q.offer(val);
                }
            }
        }

        return dp[goal] == Integer.MAX_VALUE ? -1 : dp[goal];
    }

    int solveDfsWrapper(int start) {
        Arrays.fill(dp, Integer.MAX_VALUE);
        solveDfs(start, 0);
        return dp[goal] == Integer.MAX_VALUE ? -1 : dp[goal];
    }

    void solveDfs(int cur, int step) {
        if (cur > goal) return; // 값을 넘어버린 경우

        if (dp[cur] <= step) return; // 더 빠른 방법이 존재하는 경우
        dp[cur] = step;

        for (int val : new int[]{cur + d, cur * 2, cur * 3}) {
            if (val > goal) continue;
            solveDfs(val, step + 1);
        }
    }

}