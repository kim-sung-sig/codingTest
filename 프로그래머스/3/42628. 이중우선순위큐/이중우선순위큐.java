import java.util.Arrays;
import java.util.TreeMap;

class Solution {
	public int[] solution(String[] operations) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (String op : operations) {
			String[] arr = op.split(" ");
			String o = arr[0];
			int num = Integer.parseInt(arr[1]);

			if (o.equals("I")) {
				map.merge(num, 1, Integer::sum);
				continue;
			}

			if (!map.isEmpty()) {
				int key = num == -1 ? map.firstKey() : map.lastKey();
				map.computeIfPresent(key, (k, v) -> v == 1 ? null : v - 1);
			}
		}

		if (map.isEmpty()) return new int[]{0, 0};
		return new int[]{map.lastKey(), map.firstKey()};
	}
}