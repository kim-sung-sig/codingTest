import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nb = br.readLine().split(" ");
        String n = nb[0];
        int b = Integer.parseInt(nb[1]);
        br.close();

        int result = 0;

        int len = n.length();
        for(int i = 0; i < len; i++){
            int v = n.charAt(i) + 0 >= 65 ? n.charAt(i) - 55 : Integer.parseInt(n.substring(i, i + 1));
            result += v * Math.pow(b, len - 1 - i);
        }

        System.out.println(result);
    }

}