class Solution {
    public int[] solution(long n) {
    	return new StringBuffer(String.valueOf(n)).reverse().chars().map(x -> x - '0').toArray();
    }
}