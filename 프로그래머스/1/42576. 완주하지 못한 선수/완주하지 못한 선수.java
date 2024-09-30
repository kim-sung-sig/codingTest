import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 각 이름의 출현 횟수를 저장할 해시 맵 생성
        HashMap<String, Integer> map = new HashMap<>();
        
        // 참가자 목록에 있는 이름들을 해시 맵에 추가하고 출현 횟수 카운트
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        // 완주자 목록에 있는 이름들을 해시 맵에서 출현 횟수를 줄임
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }
        
        // 출현 횟수가 양수인 이름이 정답
        for (String name : map.keySet()) {
            if (map.get(name) > 0) {
                answer = name;
                break;
            }
        }
        
        return answer;
    }
}