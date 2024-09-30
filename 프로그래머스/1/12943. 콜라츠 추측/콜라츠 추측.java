class Solution {
    public int solution(int num) {
        int answer = 0;
        if(num==1) {
            return answer;
        }
        
        Double asd = Double.valueOf(num);
        while ( answer<500) {
            answer ++;
            if(asd%2==0) {
                asd = asd/2;
            } else {
                asd = asd*3 + 1;
            }
            if(asd ==1) {
                break;
            }
        }
        if ( answer == 500) {
            answer=-1;
        }
        return answer;
    }
}