import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 분리된 값을 각각 정수로 변환하여 변수에 할당
        int[] nm = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];

        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n][m];

        // 첫 번째 배열 입력
        for (int i = 0; i < n; i++) {
            arr1[i] = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        // 두 번째 배열 입력
        for (int i = 0; i < n; i++) {
            arr2[i] = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 두 배열의 합 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr1[i][j] + arr2[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
