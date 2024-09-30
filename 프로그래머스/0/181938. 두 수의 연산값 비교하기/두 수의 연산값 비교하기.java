class Solution {
    public int solution(int a, int b) {
        int answer = 2*a*b;
        
        int aa = Integer.parseInt((a+"") + (b+""));
        
        if( answer<aa) {
            answer =aa;
        }
        return answer;
    }
}