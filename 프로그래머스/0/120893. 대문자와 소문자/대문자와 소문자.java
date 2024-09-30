class Solution {
    public String solution(String my_string) {
        StringBuffer sb = new StringBuffer();
        for(char ch : my_string.toCharArray()) {
        	if(ch+0>=97) {
        		sb.append((char)(ch-32));
        	} else {
        		sb.append((char)(ch+32));
        	}
        }
        return sb.toString();
    }
}