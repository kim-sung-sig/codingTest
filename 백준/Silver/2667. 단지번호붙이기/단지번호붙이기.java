import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            // print(arr);

            int count = 0;
            Map<Integer, Integer> countMap = new HashMap<>();
            int[][] dp = new int[N][N];
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (dp[x][y] == 0 && arr[x][y] != 0) bfs(x, y, arr, dp, ++count, countMap);
                }
            }
            // System.out.println("dp : ");
            // print(dp);
            // System.out.println("count : ");
            System.out.println(count);
            // System.out.println("countMap : ");
            // System.out.println(countMap);
            countMap.values().stream().sorted().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void bfs(int x, int y, int[][] arr, int[][] dp, int sign, Map<Integer, Integer> countMap) {
        int N = arr.length;
        if (x < 0 || y < 0 || x >= N || y >= N) return;
        if (arr[x][y] == 0) return;
        if (dp[x][y] != 0) return;

        dp[x][y] = sign;
        countMap.put(sign, countMap.getOrDefault(sign, 0) + 1);
        bfs(x + 1, y, arr, dp, sign, countMap);
        bfs(x - 1, y, arr, dp, sign, countMap);
        bfs(x, y + 1, arr, dp, sign, countMap);
        bfs(x, y - 1, arr, dp, sign, countMap);
    }

    static void print(int[][] arr) {
        for (int[] a : arr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println("");
        }
    }

}