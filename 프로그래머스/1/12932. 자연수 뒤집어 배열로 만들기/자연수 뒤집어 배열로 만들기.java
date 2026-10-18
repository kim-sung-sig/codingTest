class Solution {
    public int[] solution(long n) {
    	int[] result = new StringBuffer(String.valueOf(n)).reverse().chars().map(x -> x - '0').toArray();
        return result;
    }
}