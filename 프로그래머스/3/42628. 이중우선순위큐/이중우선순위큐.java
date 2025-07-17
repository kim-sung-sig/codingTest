import java.util.Arrays;
import java.util.TreeMap;

class Solution {
	public int[] solution(String[] operations) {
		var map = new TreeMap<Integer, Integer>();
		for (var op : operations) {
			var arr = op.split(" ");
			var o = arr[0];
			var num = Integer.parseInt(arr[1]);

			if (o.equals("I")) map.merge(num, 1, Integer::sum);
			else if (!map.isEmpty()) {
				var key = num < 0 ? map.firstKey() : map.lastKey();
				map.computeIfPresent(key, (k, v) -> v > 1 ? v - 1 : null);
			}
		}

		return map.isEmpty() ? new int[]{0, 0} : new int[]{map.lastKey(), map.firstKey()};
	}
}