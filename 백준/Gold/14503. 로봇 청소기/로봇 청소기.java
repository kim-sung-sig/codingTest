import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        int answer = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] NM = br.readLine().split(" ");
            int N = Integer.parseInt(NM[0]); int M = Integer.parseInt(NM[1]);

            String[] rcd = br.readLine().split(" ");
            int r = Integer.parseInt(rcd[0]); int c = Integer.parseInt(rcd[1]); int d = Integer.parseInt(rcd[2]);

            int vectorIndex = d;

            int[][] map = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(row[j]);
                }
            }

            // 0: clean, 1: wall, 2: cleaned
            // int step = 0;
            while (true) {
                // System.out.println("step " + ++step + " : " + r + " " + c + " " + vectorIndex);
                // System.out.println("현재 위치 : ");
                // print(r, c, map);

                if (map[r][c] == 0) { // 현 위치가 청소되어 있지 않다면
                    map[r][c] = 2; // 청소
                    answer++; // 청소 횟수 증가
                    // System.out.println("cleaned");
                }

                // System.out.println("탐색중 ... ");
                boolean needBack = true;
                for (int i = 0; i < 4; i++) { // 주변 스캡 시작
                    vectorIndex = turn(vectorIndex); // 반시계 방향으로 회전
                    int nextR = r + delta[vectorIndex][0];
                    int nextC = c + delta[vectorIndex][1];

                    if (map[nextR][nextC] == 0) { // 청소되지 않은 공간 탐색
                        r = nextR;
                        c = nextC;
                        needBack = false;
                        break;
                    }
                }

                // 탐색 후 청소할 공간이 없다면 후진
                if (needBack) {
                    // System.out.println("needBack");
                    int backR = r - delta[vectorIndex][0];
                    int backC = c - delta[vectorIndex][1];

                    if (map[backR][backC] == 1) break; // 후진할 수 없다면 종료
                    r = backR; c = backC;
                }

                // System.out.println("탐색 완료 다음 위치 : ");
                // print(r, c, map);
            }

        }

        System.out.println(answer);
    }

    static int turn(int vectorIndex) {
        return (vectorIndex + 3) % 4;
    }

    static void print(int x, int y, int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == x && j == y) System.out.print("X ");
                else System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}