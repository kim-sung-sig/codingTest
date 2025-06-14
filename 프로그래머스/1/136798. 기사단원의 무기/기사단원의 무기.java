class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int numberOfDivisors = countDivisors(i);

            answer += limit < numberOfDivisors
                    ? power
                    : numberOfDivisors;
        }

        return answer;
    }

    public int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count += (i * i == n) ? 1 : 2;
            }
        }
        return count;
    }
}