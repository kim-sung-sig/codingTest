import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int minLand = 256, maxLand = 0;
        int minTime = Integer.MAX_VALUE;
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minLand = Math.min(minLand, map[i][j]);
                maxLand = Math.max(maxLand, map[i][j]);
            }
        }

        // 가능한 모든 높이 탐색 (0~256)
        for (int targetHeight = minLand; targetHeight <= maxLand; targetHeight++) {
            int time = 0;
            int blocksNeeded = 0;
            int blocksRemoved = 0;

            // 전체 탐색하여 시간 계산
            for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) {
                int diff = map[i][j] - targetHeight;

                if (diff > 0) { // 블록 제거
                    blocksRemoved += diff;
                    time += diff * 2;
                }
                else if (diff < 0) { // 블록 추가
                    blocksNeeded -= diff;
                    time -= diff;
                }
            }

            if (blocksRemoved + B >= blocksNeeded) {
                if (time < minTime) {
                    minTime = time;
                    maxHeight = targetHeight;
                }
                else if (time == minTime) {
                    maxHeight = Math.max(maxHeight, targetHeight);
                }
            }
        }

        System.out.println(minTime + " " + maxHeight);
    }

}