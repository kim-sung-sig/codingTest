class Solution {
    public String solution(String n_str) {
    	String answer = "";
    	boolean flag = false;
        for(char ch : n_str.toCharArray()) {
        	if(ch=='0') {
        		if(flag) {
        			answer += ch;
        		}
        	} else {
        		flag = true;
        		answer +=ch;
        	}
        }
        return answer;
    }
}