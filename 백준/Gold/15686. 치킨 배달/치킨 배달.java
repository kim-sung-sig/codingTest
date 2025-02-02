import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static List<int[]> chickenRoom = new ArrayList<>();
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
                if (value == 2) chickenRoom.add(new int[]{i, j});
                map[i][j] = value;
            }
        }

        boolean[] visited = new boolean[chickenRoom.size()];
        dfs(new ArrayList<>(), visited, 0);

        System.out.println(min);
    }

    static void dfs(List<Integer> selected, boolean[] visited, int start) {
        if (selected.size() == M) {
            int total = totalChickenDistance(selected);
            min = Math.min(min, total);
            return;
        }

        for (int i = start; i < chickenRoom.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected.add(i);
                dfs(selected, visited, i + 1);
                selected.remove(selected.size() - 1);
                visited[i] = false;
            }
        }

    }

    static int getDistance(int[] home, int[] chicken) {
        return Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]);
    }

    static int totalChickenDistance(List<Integer> selected) {
        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    int minDistance = Integer.MAX_VALUE;
                    for (int index : selected) {
                        int distance = getDistance(new int[]{i, j}, chickenRoom.get(index));
                        minDistance = Math.min(minDistance, distance);
                    }
                    total += minDistance;
                }
            }
        }
        return total;
    }

}