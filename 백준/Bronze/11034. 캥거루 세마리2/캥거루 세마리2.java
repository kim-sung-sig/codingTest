import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();

            int maxJump = Math.max(B - A - 1, C - B - 1);
            System.out.println(maxJump);
        }
        sc.close();
    }

}