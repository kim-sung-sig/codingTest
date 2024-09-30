class Solution {
    public long solution(int price, int money, int count) {
        long answer = money;
        int i = count;
        while(i>=0) {
            answer -= price* i;
            i--;
        }
        if(answer >0) {
            return 0;
        }

        return (-1)*answer;
    }
}