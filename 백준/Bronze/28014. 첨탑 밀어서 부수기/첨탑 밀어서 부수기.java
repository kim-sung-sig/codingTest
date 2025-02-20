import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        int current = 0;
        while(st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken());
            if (current == 0) {
                count++;
                current = next;
                continue;
            }

            if (current <= next) {
                count++;
            }

            current = next;
        }

        System.out.println(count);
    
    }

}
