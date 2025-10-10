import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	public int solution(int n, int[][] edge) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] e : edge) {
			graph.get(e[0] - 1).add(e[1] - 1);
			graph.get(e[1] - 1).add(e[0] - 1);
		}

		boolean[] visited = new boolean[n];
		int[] distance = new int[n];

		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visited[0] = true;

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : graph.get(now)) {
				if (!visited[next]) {
					visited[next] = true;
					distance[next] = distance[now] + 1;
					q.add(next);
				}
			}
		}

		int max = Arrays.stream(distance).max().getAsInt();
		int answer = 0;
		for (int d : distance) {
			if (d == max) answer++;
		}

		return answer;
	}
}