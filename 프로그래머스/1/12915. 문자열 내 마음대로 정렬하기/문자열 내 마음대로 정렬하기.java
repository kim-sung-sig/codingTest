import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = Arrays.copyOf(strings, strings.length);
        Arrays.sort(answer, (a, b) -> {
            char ca = a.charAt(n);
            char cb = b.charAt(n);
            if (ca == cb) return a.compareTo(b);
            return Character.compare(ca, cb);
        });
        return answer;
    }
}