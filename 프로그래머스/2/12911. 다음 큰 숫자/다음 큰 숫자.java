class Solution {
    public int solution(int n) {
        int answer = 0;
        int target = solve(n);
		
        while(true) {
            n++;
            if(solve(n)==target) {
                answer = n;
                break;
            }
        }
        
        return answer;
    }
    
    static int solve(int n) {
		int answer=0;
		String s = Integer.toBinaryString(n);

		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='1') {
				answer++;
			}
		}
		return answer;
	}
}