import java.io.BufferedReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int count = 0;

        int d = 0;
        while (true) {
            d++;
            int tempSum = d * (d + 1) / 2;
            int val = n - tempSum;
            if (val < 0) break;
            if (val%d == 0) count++;
        }
        System.out.println(count);
    }
}