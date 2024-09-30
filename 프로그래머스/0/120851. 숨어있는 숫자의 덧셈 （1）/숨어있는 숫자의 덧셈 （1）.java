class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(String s : my_string.split("")) {
            try {
                answer += Integer.parseInt(s);
            } catch(Exception e) {
                
            }
        }
        return answer;
    }
}