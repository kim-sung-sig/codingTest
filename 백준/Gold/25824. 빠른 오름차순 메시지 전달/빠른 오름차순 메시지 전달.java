import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map = new int[13][13];
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 12; j++) map[i + 1][j + 1] = Integer.parseInt(st.nextToken());
        }

        dfs( 1, 0, 1); // 선생님이 1번 부터 메시지를 날림
        dfs( 2, 0, 1); // 선생님이 2번 부터 메시지를 날림

        System.out.println(minTime);
    }

    static void dfs(int current, int time, int group) {
        if (current % 2 == 1) {
            time += map[current][current + 1];
            current += 1;
        }
        else {
            time += map[current][current - 1];
            current -= 1;
        }

        if (group == 6) {
            minTime = Math.min(minTime, time);
            return;
        }

        int first = group * 2 + 1;
        int second = first + 1;

        dfs(first, time + map[current][first], group + 1);
        dfs(second, time + map[current][second], group + 1);

    }

}