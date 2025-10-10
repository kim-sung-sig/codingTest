import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
	public int solution(int n, int[][] edge) {
		List<Edges> graph = Stream.generate(Edges::new).limit(n).collect(Collectors.toList());

		Arrays.stream(edge).forEach(edges -> {
			int x = edges[0] - 1;
			int y = edges[1] - 1;
			graph.get(x).add(y);
			graph.get(y).add(x);
		});

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

class Edges implements Iterable<Integer> {
	Set<Integer> links = new HashSet<>();
	public void add(int node) {
		links.add(node);
	}

	@Override
	public Iterator<Integer> iterator() {
		return links.iterator();
	}
}