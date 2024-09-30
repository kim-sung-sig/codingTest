import java.util.*;
class Solution{
    public int solution(String s){
        int answer = 0;
		char[] chars = new char[s.length()];
		
		for(int i =0; i<chars.length; i++) {
			chars[i] = s.charAt(i);
		}
		
		
		Stack<Character> st = new Stack<>();		
		
		
		for(char ch : chars) {
			if(st.isEmpty()) {
				st.add(ch);
//				System.out.println(st);
				continue;
			}
			
			if(st.peek()==ch) {
				st.pop();
			} else {
				st.add(ch);
			}
			
//			System.out.println(st);
		}
		
//		System.out.println(st);
		if(st.isEmpty()) {
			answer =1;
		}

        
        return answer;
    }
}