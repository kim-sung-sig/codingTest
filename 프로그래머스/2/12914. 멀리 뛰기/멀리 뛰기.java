class Solution {
	public static long[][] combinationTable;
	
	
	// combinationTable 세팅해주는 함수
	public void combination(int n) {
		combinationTable = new long[n+1][n+1];
		combinationTable[1][0]=1;
		combinationTable[1][1]=1;
		for(int i =0; i<combinationTable.length; i++) {
			combinationTable[i][0]=1;
			combinationTable[i][i]=1;
		}
		
		for(int i=2; i<=n; i++) {
			for (int j=1; j<=i; j++) {
				combinationTable[i][j] = combinationTable[i-1][j-1]%1234567 + combinationTable[i-1][j]%1234567;
				combinationTable[i][j] %=1234567;
			}
		}
	}

	public long solution(int n) {
		long answer =0;
		combination(n);
		int i=0;
		while(n-i>=i) {
			answer +=combinationTable[n-i][i];
			answer %=1234567;
			i++;
		}
		
		return answer;
	}
}