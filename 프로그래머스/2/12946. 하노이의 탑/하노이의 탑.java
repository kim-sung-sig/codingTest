import java.util.*;

class Solution {
    
    List<int[]> answerList = new ArrayList<>();

    public int[][] solution(int n) {
        int[][] answer = {};
        hanoi(n, 1, 3, 2);
        return answerList.stream().toArray(int[][]::new);
    }
    
    private void hanoi(int n, int start, int to, int sub) {
        if (n == 1) {
            answerList.add(new int[]{start, to});
            return;
        }

        hanoi(n - 1, start, sub, to);
        answerList.add(new int[]{start, to});
        hanoi(n - 1, sub, to, start);
    }
}