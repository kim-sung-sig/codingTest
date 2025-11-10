import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(String begin, String target, String[] words) {
		Queue<Node> queue = new LinkedList<>();
		boolean[] visited = new boolean[words.length];

		queue.add(new Node(begin, 0));

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.word.equals(target)) return current.depth;
			for (int i = 0; i < words.length; i++) {
				if (!visited[i] && isConvertible(current.word, words[i])) {
					visited[i] = true;
					queue.add(new Node(words[i], current.depth + 1));
				}
			}
		}
		return 0;
	}
	private static boolean isConvertible(String a, String b) {
		int diff = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) diff++;
			if (diff > 1) return false;
		}
		return diff == 1;
	}

	static class Node {
		String word;
		int depth;

		Node(String word, int depth) {
			this.word = word;
			this.depth = depth;
		}
	}
}