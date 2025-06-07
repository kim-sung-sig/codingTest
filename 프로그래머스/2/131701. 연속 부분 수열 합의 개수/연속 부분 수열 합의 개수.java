import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;
        int[] arr = new int[2 * n];
        System.arraycopy(elements, 0, arr, 0, n);
        System.arraycopy(elements, 0, arr, n, n);

        // 슬라이딩 윈도우
        for (int len = 1; len <= n; len++) {
            int sum = 0;

            for (int i = 0; i < len; i++) {
                sum += arr[i];
            }
            set.add(sum);

            for (int i = 1; i < n; i++) {
                sum = sum - arr[i - 1] + arr[i + len - 1];
                set.add(sum);
            }
        }
        return set.size();
    }
}
