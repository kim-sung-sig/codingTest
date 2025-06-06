class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        String op = ineq + eq;
        boolean f = switch (op) {
            case ">=" -> n >= m;
            case ">!" -> n > m;
            case "<=" -> n <= m;
            case "<!" -> n < m;
            default -> false;
        };
        answer = f ? 1 : 0;
        return answer;
    }
}
