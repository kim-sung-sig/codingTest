class Solution {
    boolean solution(String s) {
        boolean answer = false;
        String lowerS = s.toLowerCase();
        int length = lowerS.length();

        int count = 0;
        for (int i = 0; i < length; i++) {
            char c = lowerS.charAt(i);
            if (c == 'y') count++;
            if (c == 'p') count--;
        }
        
        return count == 0;
    }
}