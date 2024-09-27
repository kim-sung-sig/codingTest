import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        int[] check = new int[2];

        if (x>=0) {
            check = new int[]{1, 4};
        } else {
            check = new int[]{2, 3};
        }

        if (y>=0) {
            System.out.println(check[0]);
        } else {
            System.out.println(check[1]);
        }
    }

}