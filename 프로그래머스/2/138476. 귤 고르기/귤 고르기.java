import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] sizeCount = new int[10_000_001];
        for (int num : tangerine) sizeCount[num]++;

        List<Integer> countList = new ArrayList<>();
        for (int count : sizeCount) if (count > 0) countList.add(count);

        countList.sort(Comparator.reverseOrder());

        int answer = 0, total = 0;
        for (int count : countList) {
            total += count;
            answer++;
            if (total >= k) break;
        }

        return answer;
    }
}