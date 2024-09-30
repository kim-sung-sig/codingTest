class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        //swap (n>m 로 고정)
        if(n<m) {
        	int tmp = n;
        	n=m;
        	m=tmp;
        } //end swap
        
        //gcd answer[0] 구하기;
        answer[0] = gcd(n,m);
        //lcm answer[1] 구하기;
        answer[1] = lcm(n,m);
        
        return answer;
    }
    public static int gcd(int a, int b) {
    	if(b==0) {
    		return a;
    	}
    	return gcd(b, a%b);
    }
    public static int lcm(int a, int b) {
    	return  (a*b) / gcd(a, b);
    }
}