import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static int[] arr = new int[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            String cmd = command[0];
            int num = -1;
            switch (cmd) {
                case "all":
                    Arrays.fill(arr, 1);
                    break;
                case "empty":
                    Arrays.fill(arr, 0);
                    break;
                case "add":
                    num = Integer.parseInt(command[1]);
                    arr[num] = 1;
                    break;
                case "remove":
                    num = Integer.parseInt(command[1]);
                    arr[num] = 0;
                    break;
                case "check":
                    num = Integer.parseInt(command[1]);
                    bw.write(arr[num] + "\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(command[1]);
                    if(arr[num] == 1) {
                        arr[num] = 0;
                    } else {
                        arr[num] = 1;
                    }
                    break;
                default:
                    break;
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

}