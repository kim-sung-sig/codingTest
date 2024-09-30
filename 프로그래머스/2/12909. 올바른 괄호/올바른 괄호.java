import java.util.*;
class Solution {
    boolean solution(String s) {
		boolean answer = false;	        
        char[] str = new char[s.length()];
        for(int i =0; i< str.length; i++) {
        	str[i]=s.charAt(i);
        }
        
	    
        Stack<Character> stack = new Stack<>();
        
        for(char k : str) {
        	if( stack.isEmpty()) {
        		if(k==')') {
        			return answer;
        		}
        		stack.push(k);
        		continue;
        	}
        	
        	if( !stack.peek().equals(k) ) {
        		stack.pop();
        	} else {
        		stack.push(k);
        	}
        }

        answer = stack.isEmpty();
        return answer;
	}
}