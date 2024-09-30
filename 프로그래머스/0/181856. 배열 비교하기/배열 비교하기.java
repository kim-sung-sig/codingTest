import java.util.stream.IntStream;

class Solution {
	public int solution(int[] arr1, int[] arr2) {
		if (arr1.length > arr2.length) {
			return 1;
		} else if( arr1.length < arr2.length) {
			return -1;
		} else {
			if (IntStream.of(arr1).sum() > IntStream.of(arr2).sum()) {
				return 1;
			} else if (IntStream.of(arr1).sum() < IntStream.of(arr2).sum()) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}