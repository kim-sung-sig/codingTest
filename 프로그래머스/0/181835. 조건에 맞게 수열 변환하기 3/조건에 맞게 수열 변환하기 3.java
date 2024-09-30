import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int k) {
        if(k%2==1) {
        	return IntStream.of(arr).map(x -> x*k).toArray();
        } else {
        	return IntStream.of(arr).map(x -> x+k).toArray();        	
        }
    }
}