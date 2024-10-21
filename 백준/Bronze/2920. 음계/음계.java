import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 백준 음계
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean asc = true;
        boolean desc = true;
        String returnStr = "";
        for(int i = 0; i < 8; i++) {
            if(arr[i] != i + 1) {
                asc = false;
            }
            if(arr[i] != 8 - i) {
                desc = false;
            }
            if(!asc && !desc) {
                returnStr = "mixed";
                break;
            }
        }

        if(asc) {
            returnStr = "ascending";
        } else if(desc) {
            returnStr = "descending";
        }

        System.out.println(returnStr);
    }
}