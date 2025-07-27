class Solution {
	public int solution(int[][] info, int n, int m) {
		boolean[][] dp = new boolean[n][m]; // 이전 훔칠
		dp[0][0] = true;

		for (int[] costs : info) {
			int aCost = costs[0];
			int bCost = costs[1];

			boolean[][] next = new boolean[n][m]; // 이번 훔칠
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < m; b++) {
					if (!dp[a][b]) continue; // 붙잡힌 경우 무시

					int ka = a + aCost;
					int kb = b + bCost;

					if (ka < n) next[ka][b] = true; // 붙잡히지 않음
					if (kb < m) next[a][kb] = true; // 붙잡히지 않음
				}
			}
			dp = next; // 이전 최신화
		}

		for (int a = 0; a < n; a++) {
			for (int b = 0; b < m; b++) {
				if (!dp[a][b]) continue;

				return a;
			}
		}
		return -1;
	}
}