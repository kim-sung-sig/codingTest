class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < food.length; i++) {
            int count = food[i]/2;

            answer.append(String.valueOf(i).repeat(count));
        }

        String reversedAnswer = new StringBuilder(answer.toString()).reverse().toString();

        return answer + "0" + reversedAnswer;
    }
}