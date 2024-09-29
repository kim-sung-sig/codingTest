import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[][] arr = new String[5][15];
        
        // 배열 입력
        int maxLength = 0;
        for (int i = 0; i < 5; i++) {
            String[] tempArr = br.readLine().split("");
            int len = tempArr.length;

            if(len > maxLength){
                maxLength = len;
            }

            arr[i] = Arrays.copyOf(tempArr, 15);
        }
        br.close();

        // 출력
        for(int i = 0; i < maxLength; i++){
            for(int j = 0; j < 5; j++){
                String s = arr[j][i];
                if(s != null){
                    bw.write(s);
                }
            }
        }
        bw.flush();
        bw.close();
    }

}