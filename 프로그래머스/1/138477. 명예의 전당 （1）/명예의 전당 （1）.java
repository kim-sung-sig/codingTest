import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : score) {
            pq.offer(s);
            if (pq.size() > k) pq.poll();
            answer.add(pq.peek());
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}