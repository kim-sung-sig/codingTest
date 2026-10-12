class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] score = new int[3];
        for (int t = 0; i < answers.length; i++) {
            int a = aVal(t); b = bVal(t); c = cVal(t);
            int ans = answers[t];
        
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            
            if (a == ans) score[0]++;
            if (b == ans) score[1]++;
            if (c == ans) score[2]++;
        }

        return answer;
    }

    
    int aVal(int t) { return t % 5 + 1; }
    
    int[] bValue2 = [1, 3, 4, 5];
    int bVal(int t) { return t % 2 == 0 ? 2 : bValue2[t / 2 % 4]; }
    
    int[] cValue = [3, 1, 2, 4, 5];
    int cVal(int t) { return cValue[t / 2 % 5]; }
}