import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] arr = new String[5][15];
        
        // 배열 입력
        int maxLength = 0;
        for (int i = 0; i < 5; i++) {
            String[] tempArr = Stream.of(sc.nextLine().split("")).toArray(String[]::new);
            int len = tempArr.length;

            if(len > maxLength){
                maxLength = len;
            }

            arr[i] = Arrays.copyOf(tempArr, 15);
        }

        // System.out.println(Arrays.deepToString(arr));

        // 출력
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < maxLength; i++){
            for(int j = 0; j < 5; j++){
                String s = arr[j][i];
                if(s != null){
                    sb.append(arr[j][i]);
                }
            }
        }
        System.out.println(sb.toString());

        sc.close();
    }
}