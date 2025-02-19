import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            int[] prefix = new int[m + 1];  // 누적합 배열 (1-based index)

            // 1. 누적합 배열 생성
            for (int j = 1; j <= m; j++) {
                prefix[j] = prefix[j - 1] + (row.charAt(j - 1) == '0' ? 1 : 0);
            }

            // 2. 연속된 k개의 '0'을 가진 구간 찾기
            for (int j = 0; j <= m - k; j++) {
                if (prefix[j + k] - prefix[j] == k) {
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
}
