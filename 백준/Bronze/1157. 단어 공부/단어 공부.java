import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        int[] count = new int[26];
        int max = 0;
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                int index = Character.toUpperCase(c) - 'A';
                count[index]++;
                max = Math.max(max, count[index]);
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean multipleMax = false;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                if (sb.length() > 0) {
                    multipleMax = true;
                    break;
                }
                sb.append((char) (i + 'A'));
            }
        }

        System.out.println(multipleMax ? "?" : sb.toString());
    }

    // 아래의 코드는 메모리와 속도측면에서 좋지 않은 코드이다. 기본형 배열을 사용하여 메모리와 속도 개선을 진행하였다.
    
    // public static void main(String[] args) throws Exception{
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     String input = br.readLine();
    //     br.close();

    //     int max = 0;
    //     Map<String, Integer> countMap = new HashMap<>();
    //     for(String str : input.split("")) {
    //         String upperStr = str.toUpperCase();
    //         countMap.merge(upperStr, 1, Integer::sum);
    //         max = Integer.max(max, countMap.getOrDefault(upperStr, 0));
    //     }

    //     StringBuilder sb = new StringBuilder();
    //     for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
    //         if(entry.getValue() == max) {
    //             if(sb.length() > 0) {
    //                 sb.setLength(0);
    //                 sb.append("?");
    //                 break;
    //             }
    //             sb.append(entry.getKey().toUpperCase());
    //         }
    //     }
    //     System.out.println(sb.toString());
    // }

}
