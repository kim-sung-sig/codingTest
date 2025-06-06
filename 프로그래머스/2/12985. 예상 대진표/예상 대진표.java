class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;

        // swap
        if (a > b) {
            int t = a; a = b; b = t;
        }

        // cal
        while (a + 1 != b || b % 2 != 0) {

            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }
        return answer;
    }
}