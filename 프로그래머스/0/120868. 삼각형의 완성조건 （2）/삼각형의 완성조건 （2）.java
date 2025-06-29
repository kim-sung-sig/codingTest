import java.util.*;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        int small = sides[0];
        return small * 2 - 1;
    }
}