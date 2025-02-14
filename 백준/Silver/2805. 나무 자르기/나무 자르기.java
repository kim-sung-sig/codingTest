import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        int max = -1;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        long start = 0;
        long end = max;

        while (start <= end) {
            long sum = 0;
            long mid = (start + end) / 2;

            for (int tree : trees) if (tree > mid) sum += tree - mid;

            if (sum >= m) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(end);

    }

}
