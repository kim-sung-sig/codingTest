import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean turn = false; // false: SK, true: CY

        if(n < 4) {
            if(n == 1) {
                turn = false;
            } else if(n == 2) {
                turn = true;
            } else if(n == 3) {
                turn = false;
            }
        } else {

            if(n % 4 == 0) {
                turn = true; // CY 가 무조건 이김
            } else if(n % 4 == 1) {
                turn = false; // SK가 무조건 이김
            } else if (n % 4 == 2) {
                turn = true;
            } else if (n % 4 == 3) { // -3 을 외치면 무조건 패배 이므로 -1을 외쳐야함 그러면 n % 4 == 2 와 역관계가 됨
                turn = false;
            }
        }


        if(turn) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
        br.close();
    }
}
