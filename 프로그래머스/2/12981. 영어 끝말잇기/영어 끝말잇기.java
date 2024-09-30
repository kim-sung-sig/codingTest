import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        // player 초기화
		int[] player = new int[n];
		for(int i=1; i <= player.length; i++) {
			player[i-1] = i;
		}
		
		int[] answer = new int[2];
		// 중복 여부 판단?을 set으로
		Set<String> set = new HashSet<String>();
		
		int count = 0;
		for(int i =0; i< words.length; i++) {
			count ++;
			if (set.isEmpty()) {
				set.add(words[i]);
				continue;
			}
			
			// 끝말잇기 모르냐?
			if(!(words[i].charAt(0) == words[i-1].charAt(words[i-1].length()-1))) {
				answer[0] = player[i%n];
				answer[1] = (count-1)/n +1;
				break;
			}
			
			//중복말햇냐?
			boolean a = set.add(words[i]);
			if(!a) {
				answer[0] = player[i%n];
				answer[1] = (count-1)/n +1;
				break;
			}
		}
		
		
		return answer;
    }
}