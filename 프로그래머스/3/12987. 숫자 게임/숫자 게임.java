import java.util.Arrays;
import java.util.Collections;

class Solution {
    public static int solution(int[] A, int[] B) {
        // 역순정렬
    	Integer[] a = Arrays.stream(A).boxed().toArray(Integer[]::new);
    	Integer[] b = Arrays.stream(B).boxed().toArray(Integer[]::new);
    	Arrays.sort(a, Collections.reverseOrder());
    	Arrays.sort(b, Collections.reverseOrder());
        int result = 0;
        int pointer = 0;
        
        for(int i = 0; i< a.length; i++) {
        	if(a[i] < b[pointer]) { // 승리가능
        		result++;
        		pointer++; // 이제 다음번째로 큰 숫자가 싸워서 이길수 잇는지 확인해야댐!
        	}
        }
        return result;
    }
    public static void main(String[] args) {
		int[] A = {5,1,3,7};
		int[] B = {2,2,6,8};
		System.out.println(solution(A, B)); 
	}
}
