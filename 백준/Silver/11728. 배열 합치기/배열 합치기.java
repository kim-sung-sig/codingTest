import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            arr[N + i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N + M; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

}