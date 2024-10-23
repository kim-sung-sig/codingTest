import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        br.close();

        System.out.println((int) Math.pow(2, n) - 1);
        hanoi(n, 1, 2, 3);
        System.out.println(sb.toString());
        // bw.flush();
        // bw.close();
    }

    public static void hanoi(int n, int start, int mid, int to) throws Exception {
        if (n == 1) {
            sb.append(start + " " + to + "\n");
            // bw.write(start + " " + to + "\n");
            return;
        }
        hanoi(n - 1, start, to, mid);
        sb.append(start + " " + to + "\n");
        // bw.write(start + " " + to + "\n");
        hanoi(n - 1, mid, start, to);
    }
}