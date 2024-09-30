import java.util.stream.IntStream;

class Solution {
    public int[] solution(int start_num, int end_num) {
        return IntStream.range(end_num, start_num + 1)
                .boxed()
                .sorted((a,b) -> b - a )
                .mapToInt(Integer::intValue)
                .toArray();
    }
}