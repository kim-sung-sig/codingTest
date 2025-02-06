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

        // System.out.println(powMod2(a, b, c));
        System.out.println(powMod3(a, b, c));
    }

    static long powMod2(int a, int b, int c) {
        if (b == 0) return 1;
        long half = powMod2(a, b / 2, c);
        long result = (half * half) % c;
        if (b % 2 == 1) result = (result * a) % c;
        return result;
    }

    static long powMod3(int a, int b, int c) {
        if (b == 0) return 1;
        if (b == 1) return a % c;

        long third = powMod3(a, b / 3, c);
        long result = (third * third) % c;
        result = (result * third) % c;

        int remainder = b % 3;
        if (remainder == 1) result = (result * a) % c;
        if (remainder == 2) {
            result = (result * a) % c;
            result = (result * a) % c;
        }

        return result;
    }

}