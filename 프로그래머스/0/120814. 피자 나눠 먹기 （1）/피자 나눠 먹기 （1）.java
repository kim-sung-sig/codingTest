class Solution {
    public int solution(int n) {
        int answer = n/7+1;
        if (n%7==0) {
            answer =n/7;
        }
        return answer;
    }
}