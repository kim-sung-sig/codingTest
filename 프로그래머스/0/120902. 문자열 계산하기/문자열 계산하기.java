class Solution {
    public int solution(String my_string) {
        String[] arr = my_string.split(" ");
        int answer = 0;
        answer += Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i += 2) {
            int sign = arr[i].equals("+") ? 1 : -1;
            answer += sign * Integer.parseInt(arr[i + 1]);
        }
        return answer;
    }
}