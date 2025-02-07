import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1부터 n까지의 제곱수 개수를 구하면 됨
        System.out.println((int) Math.sqrt(n));
    }

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) toggles(arr, i);

        System.out.println(Arrays.stream(arr).sum());
    }

    static void toggles(int[] arr, int num) {
        for (int i = 1; i < arr.length; i++) if (i % num == 0) arr[i] = arr[i] == 0 ? 1 : 0;
    }

}