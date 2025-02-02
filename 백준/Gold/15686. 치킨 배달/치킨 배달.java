import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> homes = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 0 빈칸, 1 집, 2 치킨집
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value == 1) homes.add(new int[]{i, j});
                else if (value == 2) chickens.add(new int[]{i, j});
            }
        }

        dfs(new ArrayList<>(), 0);

        System.out.println(min);
    }

    static void dfs(List<Integer> selected, int start) {
        if (selected.size() == M) {
            int total = totalChickenDistance(selected);
            min = Math.min(min, total);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.add(i);
            dfs(selected, i + 1);
            selected.remove(selected.size() - 1);
        }

    }

    static int getDistance(int[] home, int[] chicken) {
        return Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]);
    }

    static int totalChickenDistance(List<Integer> selected) {
        int total = 0;

        for (int[] home : homes) {
            int minDistance = Integer.MAX_VALUE;
            for (int index : selected) {
                int distance = getDistance(home, chickens.get(index));
                minDistance = Math.min(minDistance, distance);
            }
            total += minDistance;
        }

        return total;
    }

}