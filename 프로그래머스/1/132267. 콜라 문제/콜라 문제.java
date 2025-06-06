class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            int exchange = n / a * b;  // 병 획득
            n = (n % a) + exchange;

            answer += exchange;
        }
        return answer;
    }
}