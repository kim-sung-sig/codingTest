import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int unTomato = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                } else if(arr[i][j] == 0) {
                    unTomato++;
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
                for(int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        if(arr[nx][ny] == 0) {
                            arr[nx][ny] = 1;
                            queue.offer(new int[] {nx, ny});
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

    // public static void main(String[] args) throws Exception {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    //     int m = Integer.parseInt(st.nextToken());
    //     int n = Integer.parseInt(st.nextToken());

    //     int[][] arr = new int[n][m];
    //     for (int i = 0; i < n; i++) {
    //         st = new StringTokenizer(br.readLine(), " ");
    //         for (int j = 0; j < m; j++) {
    //             arr[i][j] = Integer.parseInt(st.nextToken());
    //         }
    //     }
    //     br.close();

    //     int count = 0;
    //     while(true) {
    //         int[][] temp = new int[n][m];
    //         for(int i = 0; i < n; i++) {
    //             temp[i] = Arrays.copyOf(arr[i], m);
    //         }

    //         for(int i = 0; i < n; i++) {
    //             for(int j = 0; j < m; j++) {
    //                 if(arr[i][j] == 1) {
    //                     if(i > 0) {
    //                         if(temp[i - 1][j] != -1) {
    //                             temp[i - 1][j] = 1;
    //                         }
    //                     }
    //                     if(i < n - 1) {
    //                         if(temp[i + 1][j] != -1) {
    //                             temp[i + 1][j] = 1;
    //                         }
    //                     }
    //                     if(j > 0){
    //                         if(temp[i][j - 1] != -1) {
    //                             temp[i][j - 1] = 1;
    //                         }
    //                     }
    //                     if(j < m - 1){
    //                         if(temp[i][j + 1] != -1) {
    //                             temp[i][j + 1] = 1;
    //                         }
    //                     }
    //                 }
    //             }
    //         }
    //         // System.out.println(Arrays.deepToString(temp));
    //         if(Arrays.deepEquals(arr, temp)) {
    //             break;
    //         }
    //         arr = temp;
    //         count++;
    //     }

    //     int zero = 0;
    //     for(int i = 0; i < n; i++) {
    //         for(int j = 0; j < m; j++) {
    //             if(arr[i][j] == 0) {
    //                 zero++;
    //                 break;
    //             }
    //         }
    //     }
    //     if(zero > 0) {
    //         count = -1;
    //     }
    //     System.out.println(count);
    // }

}