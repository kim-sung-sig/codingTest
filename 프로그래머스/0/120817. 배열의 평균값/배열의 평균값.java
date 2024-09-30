import java.util.*;
class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        int size = numbers.length;
        int sum = 0;
        
        for(int i =0; i<numbers.length; i++) {
        	sum += numbers[i];
        }
        
        answer = (double)(sum)/size;
        return answer;
    }
}