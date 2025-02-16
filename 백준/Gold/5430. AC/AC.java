import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String command = br.readLine();
            int arrLen = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();
            StringTokenizer st = new StringTokenizer(arrStr, "[],");

            int[] arr = new int[arrLen];
            for (int i = 0; i < arrLen; i++) arr[i] = Integer.parseInt(st.nextToken());

            AC ac = new AC(command, arr);
            sb.append(ac.run()).append("\n");
        }

        System.out.println(sb);
    }

}

class AC {

    StringBuilder sb = new StringBuilder();
    String command;
    int[] arr;

    public AC(String command, int[] arr) {
        this.command = command;
        this.arr = arr;
    }

    public String run() {
        int left = 0;
        int right = arr.length;
        boolean isReverse = false;

        for (char c : command.toCharArray()) {
            if (c == 'R') {
                isReverse = !isReverse;
            }
            else {
                if (left == right) return "error";

                if (isReverse) right--;
                else left++;
            }
        }

        int[] result = Arrays.copyOfRange(arr, left, right);
        sb.append("[");
        if (isReverse) {
            for (int i = result.length - 1; i >= 0; i--) {
                sb.append(result[i]);
                if (i != 0) sb.append(",");
            }
        }
        else {
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i]);
                if (i != result.length - 1) sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

}
