import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] score = Arrays.stream(patterns)
                .mapToInt(p -> (int) IntStream.range(0, answers.length)
                        .filter(i -> answers[i] == p[i % p.length])
                        .count())
                .toArray();

        int maxScore = Arrays.stream(score).max().orElse(0);
        return IntStream.range(0, 3)
                .filter(i -> score[i] == maxScore)
                .map(i -> i + 1)
                .toArray();
    }
}