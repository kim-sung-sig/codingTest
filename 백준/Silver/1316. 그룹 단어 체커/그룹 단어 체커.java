import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer n = sc.nextInt();

        Integer count = 0;
        while (n > 0) {
            Long result = 0L;
            String str = sc.next();
            Long defferCount = Stream.of(str.split("")) // fga = 3 , ffa = 2
                    .distinct()
                    .count();

            for(int i = 0; i < str.length() - 1; i++) {
                if(str.charAt(i) == str.charAt(i + 1)) {
                    continue;
                }
                result ++;
            }
            if(result.equals(defferCount - 1)) {
                count++;
            }

            n--;
        }

        System.out.println(count);

        sc.close();
    }
}