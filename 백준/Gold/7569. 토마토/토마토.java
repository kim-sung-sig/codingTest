import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[n][m][h];
        Queue<int[]> queue = new LinkedList<>();
        int unTomato = 0;

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < m; j++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        queue.offer(new int[] {i, j, k});
                    } else if (arr[i][j][k] == 0) {
                        unTomato++;
                    }
                }
            }
        }
        br.close();

        if(unTomato == 0) {
            System.out.println(0); // early return
            return;
        }

        int count = 0;
        while(!queue.isEmpty()) {
            boolean flag = false;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];
                int z = temp[2];
                for(int j = 0; j < 6; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    int nz = z + dz[j];
                    if(nx >= 0 && ny >= 0 && nz >= 0 && nx < n && ny < m && nz < h) {
                        if(arr[nx][ny][nz] == 0) {
                            arr[nx][ny][nz] = 1;
                            queue.offer(new int[] {nx, ny, nz});
                            unTomato--;
                            flag = true;
                        }
                    }
                }
            }

            if(flag) {
                count++;
            }

        }

        if(unTomato > 0) {
            count = -1;
        }
        System.out.println(count);
    }

}