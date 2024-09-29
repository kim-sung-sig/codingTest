import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        StringBuffer str1 = new StringBuffer(input[0]);
        StringBuffer str2 = new StringBuffer(input[1]);

        str1.reverse();
        str2.reverse();

        System.out.println(Integer.parseInt(str1.toString()) > Integer.parseInt(str2.toString()) ? str1 : str2);
    }

}