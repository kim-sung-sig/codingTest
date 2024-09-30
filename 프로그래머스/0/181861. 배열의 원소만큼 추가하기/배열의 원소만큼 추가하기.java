import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        int count =0;
        while(count<arr.length) {
        	for(int i =0; i<arr[count];i++) {
        		list.add(arr[count]);
        	}
            count++;
        }
        int[] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}