import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right+1-left)];

        
        for(long i = left; i<=right ;i++) {
        	int lineNum = (int)(i/n);
        	int idxNum = (int)(i%n);
        	
        	int k =0;
        	
        	if(lineNum<idxNum) {
        		k = idxNum+1;
        	} else {
        		k= lineNum+1;
        	}
        	answer[(int)(i-left)] = k;
        	
        }

        return answer;
    }
}