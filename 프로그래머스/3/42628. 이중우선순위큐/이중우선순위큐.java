import java.util.Arrays;
import java.util.TreeMap;

class Solution {
	public int[] solution(String[] operations) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (String op : operations) {
			String[] arr = op.split(" ");
			String o = arr[0];
			int num = Integer.parseInt(arr[1]);

			if (o.equals("D") && !map.isEmpty()) {
				int key = num == -1 ? map.firstKey() : map.lastKey();
				int count = map.get(key);
				var i = count == 1 ? map.remove(key) : map.put(key, count - 1);
			} else if (o.equals("I")) {
				map.merge(num, 1, Integer::sum);
			}
		}

		if (map.isEmpty()) return new int[]{0, 0};
		return new int[]{map.lastKey(), map.firstKey()};
	}
}