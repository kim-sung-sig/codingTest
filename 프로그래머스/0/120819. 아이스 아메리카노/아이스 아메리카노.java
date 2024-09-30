class Solution {
    public int[] solution(int money) {
        int[] answer = new int[2];
        int q = money/5500;
        int r = money - 5500*q;
        answer[0] = q;
        answer[1] = r;
        return answer;
    }
}