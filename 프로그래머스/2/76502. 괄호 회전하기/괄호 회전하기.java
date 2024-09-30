import java.util.*;
class Solution {
    public int solution(String s) {
        int answer =0;
		char[] ch = s.toCharArray();
		
		
		for(int i=0; i<s.length();i++) {
			
			
			Stack<Character> strack = new Stack<>();

			for(int j =0;j<s.length() ; j++) {
				
				if(strack.isEmpty()) {
					if(ch[(i+j)%s.length()] == ')' || ch[(i+j)%s.length()] == '}' || ch[(i+j)%s.length()] == ']') {
						strack.add(ch[((i+j)%s.length())]);
						break;
					}
					
					strack.add(ch[(i+j)%s.length()]);
					continue;
				}
				if( (int)strack.peek()==(int)(ch[((i+j)%s.length())]) - 1 || (int)strack.peek() ==(int)(ch[((i+j)%s.length())]) - 2) { // char 값이
					strack.pop();
				} else {
					strack.add(ch[((i+j)%s.length())]);
				}
			} //for
			System.out.println(strack);
			if(strack.isEmpty()) {
				answer ++;
			}
			
		} //for
        
        return answer;
    }
}