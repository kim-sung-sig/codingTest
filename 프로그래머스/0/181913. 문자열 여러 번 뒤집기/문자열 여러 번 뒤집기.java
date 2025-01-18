class Solution {
    public String solution(String my_string, int[][] queries) {
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            String temp = my_string.substring(start, end + 1);
            StringBuilder sb = new StringBuilder(temp);
            my_string = my_string.substring(0, start) + sb.reverse().toString() + my_string.substring(end + 1);
        }
        return my_string;
    }
}