import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(int n) {
		List<Integer> list = new ArrayList<Integer>();
		while (n != 1) {
			list.add(n);
			if (n % 2 == 0) n /= 2;
			else n = 3 * n + 1;
		}
		list.add(n);
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
