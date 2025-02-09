import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] grid = new boolean[101][101];

        br.lines()
            .limit(4)
            .map(line -> Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray())
            .forEach(arr -> {
                int x1 = arr[0], y1 = arr[1], x2 = arr[2], y2 = arr[3];
                for (int i = x1; i < x2; i++) for (int j = y1; j < y2; j++) grid[i][j] = true;
            });

        int count = 0;
        for (int i = 1; i < 101; i++) for (int j = 1; j < 101; j++) if (grid[i][j]) count++;

        System.out.println(count);
    }

}