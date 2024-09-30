class Solution {
    public String solution(String s) {
        String answer = "";
        String[] list1 = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i =0; i<list1.length;i++) {
        	int value = Integer.parseInt(list1[i]);
        	
        	min = Math.min(min, value);
        	max = Math.max(max, value);
        }
        
        answer = (""+min)+" " + ("" + max);
        
        
        return answer;
    }
}