import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        LocalTime time = LocalTime.of(h, m);
        time = time.minusMinutes(45);

        System.out.println(time.getHour() + " " + time.getMinute());

    }

}