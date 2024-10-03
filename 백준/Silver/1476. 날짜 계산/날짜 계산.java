import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] esm = br.readLine().split(" ");
        int E = Integer.parseInt(esm[0]); // 0<=e<=14
        int S = Integer.parseInt(esm[1]); // 0<=s<=27
        int M = Integer.parseInt(esm[2]); // 0<=m<=18
        br.close();

        int year = 1;
        int e = 1;
        int s = 1;
        int m = 1;
        while (true) {
            if(E == e && S == s && M == m) {
                break;
            }
            e++;
            s++;
            m++;
            year++;
            if(e > 15) {
                e = 1;
            }
            if(s > 28) {
                s = 1;
            }
            if(m > 19) {
                m = 1;
            }
        }

        System.out.println(year);
    }

}
