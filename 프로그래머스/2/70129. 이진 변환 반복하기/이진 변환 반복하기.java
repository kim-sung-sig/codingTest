class Solution {
	static int count=0; // 이진 변환횟수
	static int zerocount = 0; // 지운 영의 갯수
	
    public int[] solution(String s) {
    	resursion(s);
    	
    	int[] result = {count, zerocount};
        
    	return result;
    }
    
    public void resursion(String s) {
    	// 정지 포인트
    	if(s.equals("1")) {
        	return;
        }
    	count++;
    	int ivcount = 0;
        for(int i=0; i<s.length() ; i++) {
        	if(s.substring(i,i+1).equals("0")) {
        		zerocount++;
        		ivcount++;
        	}
        }
        String newStr = Integer.toBinaryString(s.length() - ivcount);
        resursion(newStr);
        
    }
}