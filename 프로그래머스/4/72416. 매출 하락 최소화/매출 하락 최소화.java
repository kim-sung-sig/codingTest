import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

class Solution {

	static int INF = Integer.MAX_VALUE;

	public static int solution(int[] sales, int[][] links) {

		// cost[i][0]: i직원 참가 시 최소 비용
		// cost[i][1]: i직원 불참 시 최소 비용
		int[][] cost = new int[sales.length + 1][2];
		Arrays.stream(cost).forEach(arr -> Arrays.fill(arr, INF));

		// 팀장 - 팀원 관계를 그래프로 표현
		// key: 팀장, value: 팀원 집합
		Map<Integer, Set<Integer>> tree = new HashMap<>();
		Arrays.stream(links).forEach(link ->
				tree.computeIfAbsent(link[0], k -> new HashSet<>()).add(link[1])
		);

		dfs(1, tree, sales, cost);

		return Math.min(cost[1][0], cost[1][1]);
	}

	private static void dfs(int node, Map<Integer, Set<Integer>> graph, int[] sales, int[][] cost) {
		cost[node][0] = sales[node - 1];
		cost[node][1] = 0;

		Set<Integer> children = graph.get(node);
		if (children == null || children.isEmpty()) return;

		int extra = INF;
		for (int child : children) {
			dfs(child, graph, sales, cost);

			if(cost[child][0] < cost[child][1]) {
				cost[node][0] += cost[child][0];
				cost[node][1] += cost[child][0];
				extra = 0;
			}
			else {
				cost[node][0] += cost[child][1];
				cost[node][1] += cost[child][1];
				extra = Math.min(extra, cost[child][0] - cost[child][1]);
			}
		}
		cost[node][1] += extra;
	}
}