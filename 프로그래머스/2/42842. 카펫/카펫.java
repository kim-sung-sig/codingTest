class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
		
		for(int i =1; i <= yellow; i++) {
			if(yellow%i==0) {
				int x = i;//1
				int y = yellow/i;//2
							// 3     4        2 = 10
				if( brown == (x+2)*(y+2) - yellow) {
					answer[1] = x+2;
					answer[0] = y+2;
					break;
				}
			}
		}
        return answer;
    }
}