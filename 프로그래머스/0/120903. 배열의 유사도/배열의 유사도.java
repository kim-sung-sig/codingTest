import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Solution {
    
    // O(n + m) = O(max(n,m))
    public int solution(String[] s1, String[] s2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(s1)); // s1을 HashSet으로 변환
        Set<String> set2 = new HashSet<>(Arrays.asList(s2)); // s2를 HashSet으로 변환

        set1.retainAll(set2); // set1과 set2의 교집합을 set1에 저장
        return set1.size(); // 교집합의 크기를 반환
    }
    
    // O(n^2)
    // public int solution(String[] s1, String[] s2) {
    //     int answer = 0;
    //     for(int i=0; i<s1.length; i++){
    //         for(int j=0; j<s2.length; j++){
    //             if(s1[i].equals(s2[j])) {
    //                 answer++;
    //             }
    //         }
    //     }
    //     return answer;
    // }
}