import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        double[] result = new double[c];
        for(int i = 0; i < c; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int[] score = new int[n];
            int sum = 0;
            for(int j = 0; j < n; j++) {
                score[j] = Integer.parseInt(input[j+1]);
                sum += score[j];
            }

            double avg = sum / (double) n;
            double count = 0;
            for(int j = 0; j < n; j++) {
                if(score[j] > avg) {
                    count++;
                }
            }
            result[i] = count / n * 100;
        }
        br.close();
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < c; i++) {
            bw.write(String.format("%.3f", result[i]) + "%\n");
        }
        bw.flush();
        bw.close();
    }

}