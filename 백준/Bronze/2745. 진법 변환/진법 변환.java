import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] NandB = sc.nextLine().split(" ");
        String N = NandB[0];
        int B = Integer.parseInt(NandB[1]);

        int value = 0;

        int len = N.length();
        for(int i = 0; i < len; i++){
            int v = N.charAt(i) + 0 >= 65 ? N.charAt(i) - 55 : Integer.parseInt(N.substring(i, i + 1));
            value += v * Math.pow(B, len - 1 - i);
        }

        System.out.println(value);

        sc.close();
    }
}