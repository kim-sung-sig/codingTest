class Solution {
    public int solution(int balls, int share) {
        return (int) combination(balls, share);
    }
    
    public long combination(int n, int r) {
        if (r == 0 || n == r) return 1L;
        if (r > n) return 0L;
        
        long result = 1L;
        for (int i = 1; i <= r; i++) {
            result = result * (n - i + 1) / i;
        }
        return result;
    }
}