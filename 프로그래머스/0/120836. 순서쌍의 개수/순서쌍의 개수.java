class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean juge = false;
        int count =0;
        if(Math.sqrt(n) == (int)Math.sqrt(n)){juge=true;}
        for(int i=1; i<=n;i++){
            if(n%i==0) {
                count++;
            }
        }
        answer +=count;
        
        return answer;
    }
}