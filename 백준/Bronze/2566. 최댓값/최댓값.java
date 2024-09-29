import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[9][9];

        // 배열 입력
        for (int i = 0; i < 9; i++) {
            arr[i] = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int max = -1;
        int x = -1;
        int y = -1;

        // 최대값 찾기
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                int val = arr[i][j];
                if(val > max){
                    max = val;
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((x+1) + " " + (y+1));

        sc.close();
    }
}