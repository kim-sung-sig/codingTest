import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int i = 0;

        while (i < arr.length) {
            if (st.isEmpty()) {
                st.push(arr[i]);
                i++;
            } else if (st.peek() < arr[i]) {
                st.push(arr[i]);
                i++;
            } else {
                st.pop();
            }
        }

        return st.stream().mapToInt(Integer::intValue).toArray();
    }
}