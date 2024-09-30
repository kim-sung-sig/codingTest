import java.util.Arrays;

class Solution {
    public int[] solution(String myString) {
    	if(myString.endsWith("x")) {
    		int[] arr = Arrays.stream(myString.split("x")).map(x -> x.length()).mapToInt(x->x).toArray();
    		int[] answer = Arrays.copyOf( arr , arr.length+1);
    		answer[answer.length-1] = 0;
    		return answer;
    	} else {
    		return Arrays.stream(myString.split("x")).map(x -> x.length()).mapToInt(x->x).toArray();    		
    	}
    }
}