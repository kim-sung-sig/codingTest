import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[][] grid;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = br.lines()
            .limit(n)
            .map(line -> line.chars().map(c -> c == '_' ? 0 : 1).toArray())
            .toArray(int[][]::new);

        int[] 심장 = findHearts();
        int 왼팔 = findLength(심장, new int[]{0, -1});
        int 오른팔 = findLength(심장, new int[]{0, 1});
        int 몸통 = findLength(심장, new int[]{1, 0});

        int[] 허리끝 = new int[]{심장[0] + 몸통, 심장[1]};
        int[] 왼다리 = new int[]{허리끝[0], 허리끝[1] - 1};
        int[] 오른다리 = new int[]{허리끝[0], 허리끝[1] + 1};

        int 왼쪽다리 = findLength(왼다리, new int[]{1, 0});
        int 오른쪽다리 = findLength(오른다리, new int[]{1, 0});

        System.out.println((심장[0] + 1) + " " + (심장[1] + 1));
        System.out.println(왼팔 + " " + 오른팔 + " " + 몸통 + " " + 왼쪽다리 + " " + 오른쪽다리);

    }

    static int[] findHearts() {
        for (int i = 1; i < n - 1; i++) for (int j = 1; j < n - 1; j++) if (grid[i][j] == 1 && grid[i - 1][j] == 1 && grid[i + 1][j] == 1 && grid[i][j - 1] == 1 && grid[i][j + 1] == 1) return new int[]{i, j};
        return null;
    }

    static int findLength(int[] start, int[] vector) {
        int length = 0;
        int x = start[0], y = start[1];
        while (true) {
            x += vector[0];
            y += vector[1];
            if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y] != 1) break;
            length++;
        }
        return length;
    }

}