class Solution {
    public int solution(int n) {
        int answer = 2;
        if( Math.sqrt(n) == (int)Math.sqrt(n) ) {
            answer =1;
        }
        return answer;
    }
}