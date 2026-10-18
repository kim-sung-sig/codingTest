class Solution {
    boolean solution(String s) {
        boolean answer = false;
        s = s.toLowerCase();
        answer = s.replaceAll("y", "").length() - s.replaceAll("p", "").length() == 0 ? true : false; 
        return answer;
    }
}