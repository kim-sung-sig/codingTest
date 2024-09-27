import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] hm = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int plus = Integer.parseInt(br.readLine());

        LocalTime time = LocalTime.of(hm[0], hm[1]);
        time = time.plusMinutes(plus);

        System.out.println(time.getHour() + " " + time.getMinute());
    }

}