import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1) {
    		return new int[] {-1};
    	}
    	int min = Arrays.stream(arr).min().getAsInt();
    	
    	int[] answer = Arrays.stream(arr).filter(x->x>min).toArray();
        
        return answer;
    }
}