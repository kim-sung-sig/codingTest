import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        if (isPerfectSquare(n)) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i * i <= n; i++) {
            if (isPerfectSquare(n - i * i)) {
                System.out.println(2);
                return;
            }
        }

        for (int i = 1; i * i <= n; i++) {
            for (int j = 1; j * j <= n - i * i; j++) {
                if (isPerfectSquare(n - i * i - j * j)) {
                    System.out.println(3);
                    return;
                }
            }
        }

        System.out.println(4);
    }

    static boolean isPerfectSquare(int x) {
        int sqrt = (int) Math.sqrt(x);
        return sqrt * sqrt == x;
    }

}