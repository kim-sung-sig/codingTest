import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int totalWant = 0; // 전체 원하는 상품 수 (총합)

        // 1. 원래 원하는 상품 Map 구성
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
            totalWant += number[i];
        }

        // 2. 슬라이딩 윈도우로 discount에서 원하는 상품만큼 검사
        for (int i = 0; i <= discount.length - totalWant; i++) {
            Map<String, Integer> windowMap = new HashMap<>();

            for (int j = i; j < i + totalWant; j++) {
                windowMap.merge(discount[j], 1, Integer::sum);
            }

            if (Objects.equals(wantMap, windowMap)) {
                answer++;
            }
        }
        return answer;
    }
}