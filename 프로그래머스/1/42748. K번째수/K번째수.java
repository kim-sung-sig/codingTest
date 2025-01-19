import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int r = 0;
        for (int[] command : commands) {
            int i = command[0], j = command[1], k = command[2];
            int[] temp = Arrays.copyOfRange(array, i - 1, j);

            Arrays.sort(temp);
            answer[r++] = temp[k - 1];
        }

        return answer;
    }
}