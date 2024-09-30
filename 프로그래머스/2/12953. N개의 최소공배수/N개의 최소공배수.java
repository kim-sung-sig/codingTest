import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer= 0;
		Arrays.sort(arr);
		int i =2;
		
		while (true) {
			int count = 0;
			int temp = arr[arr.length-1]*i;
			for(int j=0; j<arr.length-1; j++) {
				if(temp%arr[j]==0) {
					count ++;
				}
			}
			
			if(count == arr.length-1) {
				answer = temp;
				break;
			}
			i++;
		}
		
		
		return answer;
    }
}