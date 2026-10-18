import java.util.BitSet;

class Solution {
    public int solution(int[][] signals) {
        int lcm = 1;
        for (int[] signal : signals) lcm = lcm(lcm, signal[0] + signal[1] + signal[2]);

        BitSet candidates = new BitSet(lcm);                                   
        candidates.set(0, lcm);
                        
        for (int[] signal : signals) {
            int g = signal[0];
            int y = signal[1];
            int period = g + y + signal[2];
            
            BitSet curr = new BitSet(lcm);
            
            for (int start = 0; start < lcm; start += period) {
                int from = start + g + 1;
                int to = Math.min(start + g + y + 1, lcm);
                
                if (from < to) curr.set(from, to);
            }
            
            candidates.and(curr);
            
            if (candidates.isEmpty()) return -1;
        }
        
        return candidates.nextSetBit(1);            
    }
    
    int gcd(int a, int b) {
        while (b != 0) { int temp = a % b; a = b; b = temp; }
        return a;
    }
    int lcm(int a, int b) { return a / gcd(a, b) * b; }
}