import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = br.readLine();
        br.close();

        int[] arr = new int[10];
        for(String str : n.split("")) {
            int num = Integer.parseInt(str);
            arr[num]++;
        }

        arr[6] = (arr[6] + arr[9] + 1) / 2;
        arr[9] = 0;

        int max = Arrays.stream(arr).max().getAsInt();
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

}