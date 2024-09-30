import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = Arrays.copyOfRange(num_list, n, n+num_list.length);
        System.out.println(Arrays.toString(answer));
        for(int i = 0; i < n; i++) {
        	answer[answer.length-n+i] = num_list[i];
        }
        return answer;
    }
}