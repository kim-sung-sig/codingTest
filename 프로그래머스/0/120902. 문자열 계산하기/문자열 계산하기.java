class Solution {
    public int solution(String my_string) {
        String[] arr = my_string.split(" ");
        int answer = 0;
        int first = Integer.parseInt(arr[0]);

        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i].equals("+")) first += Integer.parseInt(arr[i + 1]);
            else if (arr[i].equals("-")) first -= Integer.parseInt(arr[i + 1]);
        }

        answer = first;
        return answer;
    }
}