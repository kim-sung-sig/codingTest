import java.util.Arrays;

class Solution {

	public int[] solution(int[] num_list) {
		int[] answer = Arrays.copyOf(num_list, num_list.length+1);
		if (num_list[num_list.length - 2] < num_list[num_list.length - 1]) {
			answer[answer.length-1] = answer[answer.length-2] - answer[answer.length-3];
		} else if (num_list[num_list.length - 2] >= num_list[num_list.length - 1]) {
			answer[answer.length-1] = answer[answer.length-2]*2;
		}
		return answer;
	}
}