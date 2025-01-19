import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int priority : priorities) {
            queue.add(priority);
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            boolean flag = true; // 실행 할지 여부
            for (int priority : queue) {
                if (current < priority) {
                    flag = false; // 높은 우선 순위가 큐에 있을 경우
                    break;
                }
            }

            if (flag) {
                answer++;
                if (location == 0) break;
            }
            else {
                queue.add(current);
            }

            location--;
            if (location < 0) location = queue.size() - 1;
        }

        return answer;
    }
}