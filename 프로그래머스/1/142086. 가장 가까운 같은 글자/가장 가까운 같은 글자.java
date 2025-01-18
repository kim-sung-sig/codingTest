import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Integer> map;
    public int[] solution(String s) {
        map = new HashMap<>();

        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);

            int m = map.getOrDefault(str, -1);
            if (m != -1) m = i - m;
            answer[i] = m;
            map.put(str, i);
        }

        return answer;
    }
}