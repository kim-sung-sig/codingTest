import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int N = (1 << n); // 2^n
        int result = findDirection(x, y, N, 0);
        System.out.println(result);
    }

    static int findDirection(int x, int y, int size, int count) {
        if (size == 1) return count;

        int half = size / 2;
        if (x < half && y < half) return findDirection(x, y, half, count);
        else if (x < half && y >= half) return findDirection(x, y - half, half, count + half * half);
        else if (x >= half && y < half) return findDirection(x - half, y, half, count + half * half * 2);
        else return findDirection(x - half, y - half, half, count + half * half * 3);
    }

}