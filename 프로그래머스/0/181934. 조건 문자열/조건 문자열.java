class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        boolean f = false;
        if (ineq.equals(">")) {
            if (eq.equals("=")) {
                f = n >= m;
            } else {
                f = n > m;
            }
        } else {
            if (eq.equals("=")) {
                f = n <= m;
            } else {
                f = n < m;
            }
        }
        answer = f ? 1 : 0;
        return answer;
    }
}