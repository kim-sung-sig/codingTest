import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Solution {

	static int INF = Integer.MAX_VALUE;

	public static int solution(int[] sales, int[][] links) {

		int n = sales.length;

		// 팀장 - 팀원 관계를 그래프로 표현
		List<List<Integer>> childrenList = new ArrayList<>();
		for (int i = 0; i <= n; i++) childrenList.add(new ArrayList<>());
		for (int[] link : links) childrenList.get(link[0]).add(link[1]);

		int[][] cost = new int[sales.length + 1][2];

		dfs(1, childrenList, sales, cost);

		return Math.min(cost[1][0], cost[1][1]);
	}

	private static void dfs(int node, List<List<Integer>> childrenList, int[] sales, int[][] cost) {
		cost[node][0] = sales[node - 1];
		cost[node][1] = 0;

		if (childrenList.get(node).isEmpty()) return;

		int minAttendDiff = INF;
		boolean hasAttendingChild = false;

		for (int child : childrenList.get(node)) {
			dfs(child, childrenList, sales, cost);

			int attend = cost[child][0];
			int notAttend = cost[child][1];

			int minCost = Math.min(attend, notAttend);

			cost[node][0] += minCost;
			cost[node][1] += minCost;

			if (attend < notAttend) {
				hasAttendingChild = true;
				continue;
			}

			minAttendDiff = Math.min(minAttendDiff, attend - notAttend);
		}

		if (hasAttendingChild) return;

		cost[node][1] += minAttendDiff;
	}
}