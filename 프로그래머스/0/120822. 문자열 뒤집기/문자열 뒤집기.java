class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(int k = my_string.length()-1 ; k>=0; k--) {
            answer +=my_string.substring(k,k+1);
        }
        return answer;
    }
}