class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int mult=1;
        int sum=0;
        
        for(int i : num_list) {
        	mult *=i;
        	sum += i;
        }
        
        if(mult < Math.pow(sum, 2)) {
        	answer = 1;
        }
        return answer;
    }
}