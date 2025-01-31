import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[][] arr = new int[N][N];

        fill(arr, 0, 0, N);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int mark = arr[i][j];
                sb.append(mark == 0 ? "*" : " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }


    private static void fill(int[][] arr, int x, int y, int size) {

        if (size == 1) return;

        int subSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 중간 1/3 영역은 비운다.
                if (i == 1 && j == 1) {
                    for (int a = x + subSize; a < x + 2 * subSize; a++) {
                        for (int b = y + subSize; b < y + 2 * subSize; b++) {
                            arr[a][b] = 1;
                        }
                    }
                } else {
                    fill(arr, x + i * subSize, y + j * subSize, subSize);
                }
            }
        }

    }
}