import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.close();

        Arrays.sort(arr); // 정렬 후 투 포인터로 접근

        int sum = -1;

        for(int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while(left < right) {
                int tempSum = arr[i] + arr[left] + arr[right];

                if(tempSum == M) { // 일치시 얼리 리턴
                    sum = tempSum;
                    break;
                }

                if(tempSum < M) {
                    sum = Math.max(sum, tempSum);
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(sum);

    }

    // 부루트 포스
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    //     int N = Integer.parseInt(st.nextToken());
    //     int M = Integer.parseInt(st.nextToken());

    //     int[] arr = Arrays.stream(br.readLine().split(" "))
    //             .mapToInt(Integer::parseInt)
    //             .toArray();
    //     br.close();

    //     int sum = -1;
    //     for (int i = 0; i < N - 2; i++) {

    //         if(arr[i] >= M) continue; // skip

    //         for (int j = i + 1; j < N - 1; j++) {

    //             if(arr[i] + arr[j] >= M) continue; // skip

    //             for (int k = j + 1; k < N; k++) {
    //                 int tempSum = arr[i] + arr[j] + arr[k];

    //                 if (tempSum <= M && tempSum > sum) {
    //                     sum = tempSum;
    //                 }
    //             }
    //         }
    //     }

    //     System.out.println(sum);
    // }

}