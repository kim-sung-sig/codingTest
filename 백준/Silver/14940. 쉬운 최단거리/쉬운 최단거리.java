import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] result = new int[N][M];
        IntStream.range(0, N).forEach(i -> Arrays.fill(result[i], -1));

        Queue<Main.Node> queue = new LinkedList<>();

        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                String input = st.nextToken();
                if (input.equals("0")) {
                    result[i][j] = 0;
                }
                else if (input.equals("2")) {
                    result[i][j] = 0;
                    queue.add(new Main.Node(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            Main.Node current = queue.poll();
            int x = current.x;
            int y = current.y;
            int c = current.c;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (result[nextX][nextY] >= 0) continue;

                queue.add(new Main.Node(nextX, nextY, c + 1));
                result[nextX][nextY] = c + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static class Node {
        int x;
        int y;
        int c;

        public Node(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

}