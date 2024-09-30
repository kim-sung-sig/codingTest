class Solution {
    public int solution(int n) {
        int answer = 1;
		for(int i =2; i<n; i++) {
			int tmp = n;
			int sum = 0;
			
			for(int j=1; j <= i; j++) {
				sum+=j;
			}
			if(sum>n) {
				break;
			}
			tmp -= sum;
			
			if(tmp%i==0) {
				answer++;
			}
		}
        return answer;
    }
}