class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        // 에라토스테네스 체
        int[] divisorCount = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            for (int j = i; j <= number; j += i) {
                divisorCount[j]++;
            }
        }

        for (int i = 1; i <= number; i++) {
            int numberOfDivisors = divisorCount[i];
            answer += (numberOfDivisors > limit)
                    ? power
                    : numberOfDivisors;
        }

        return answer;
    }
}