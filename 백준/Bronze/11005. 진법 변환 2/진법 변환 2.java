import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        if(n == 0){
            System.out.println("0");
            System.exit(0);
        }

        StringBuffer sb = new StringBuffer();

        while(n > 0){
            int temp = n % b;
            sb.append(temp < 10 ? temp : Character.toString((char)(temp + 55)));
            n /= b;
        }

        System.out.println(sb.reverse().toString());

        sc.close();
    }
}