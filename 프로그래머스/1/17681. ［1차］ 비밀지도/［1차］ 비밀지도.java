import java.util.Arrays;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            int merge = arr1[i] | arr2[i];

            String v = Integer.toString(merge, 2);
            if (v.length() < n) {
                v = "0".repeat(n - v.length()) + v;
            }

            v = v.replace('1', '#').replace('0', ' ');
            System.out.println(v);
            answer[i] = v;
        }
        return answer;
    }
}