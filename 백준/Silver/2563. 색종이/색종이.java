import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[][] arr = new int[100][100];
        int sum = 0;
        while(n > 0) {

            int[] xy = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = xy[0];
            int y = xy[1];

            for(int i = x; i < x + 10; i++){
                for(int j = y; j < y + 10; j++){
                    if(arr[i][j] == 1){
                        continue;
                    }
                    arr[i][j] = 1;
                    sum++;
                }
            }
            n--;
        }
        System.out.println(sum);

        sc.close();
    }
}
