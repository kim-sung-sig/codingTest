import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static BufferedReader br;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            Stack<String> stack = new Stack<>();

            for (String s : input) {
                if (s.equals("(")) {
                    stack.push(s);
                } else {
                    if (stack.isEmpty()) {
                        stack.push(s);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if(stack.isEmpty()) {
                result[i] = "YES";
            } else {
                result[i] = "NO";
            }
        }


        for(String s : result) {
            System.out.println(s);
        }
    }

}