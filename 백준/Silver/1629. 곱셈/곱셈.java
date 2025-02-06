import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(powMod(a, b, c));
    }

    static long powMod(int a, int b, int c) {
        if (b == 0) return 1;
        long half = powMod(a, b / 2, c);
        long result = (half * half) % c;
        if (b % 2 == 1) result = (result * a) % c;
        return result;
    }

}