class Solution {
    static int[] bottom_table;
    
    public int solution(int n) {
        bottom_table = new int[n+1];
        
        return fiboBU(n);
    }
    
	static int fiboBU(int n) {
		bottom_table[0]=0; bottom_table[1] =1;
		
		if(bottom_table[n]>0) return bottom_table[n];
		
		
		for(int i = 2; i <= n; i++) {
			bottom_table[i] = (bottom_table[i-1]%1234567) + (bottom_table[i-2]%1234567);
		}
		
		return bottom_table[n]%1234567;
	}
    
    
    
    static int fibo(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        
        return fibo(n-1)%1234567 + fibo(n-2)%1234567;
    }
    
}