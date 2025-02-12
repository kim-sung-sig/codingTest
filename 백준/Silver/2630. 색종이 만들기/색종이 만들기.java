import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int white = 0, blue = 0;

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Queue<Pick> q = new LinkedList<>();
        q.add(new Pick(0, 0, n));

        while (!q.isEmpty()) {
            Pick p = q.poll();
            int x = p.x;
            int y = p.y;
            int size = p.size;

            int[][] subMap = new int[size][size];
            for (int i = 0; i < size; i++) subMap[i] = Arrays.copyOfRange(map[i + x], y, y + size);
            // System.out.println(Arrays.deepToString(subMap));

            boolean isPossible = isPossible(subMap);

            if (isPossible) {
                if (subMap[0][0] == 0) white++;
                else blue++;
            }
            else {
                int newSize = size / 2;
                q.add(new Pick(x, y, newSize));
                q.add(new Pick(x + newSize, y, newSize));
                q.add(new Pick(x, y + newSize, newSize));
                q.add(new Pick(x + newSize, y + newSize, newSize));
            }
        }

        System.out.println(white);
        System.out.println(blue);

    }

    static boolean isPossible(int[][] map) {
        int start = map[0][0];
        return Arrays.stream(map)
                .flatMapToInt(Arrays::stream)
                .allMatch(i -> i == start);
    }

}

class Pick {
    int x, y, size;

    public Pick(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

}