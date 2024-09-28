import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

        int tempA = 1, tempColumn = 1;
        while(n >= tempA) {
            tempA += tempColumn++;
        }

        int a = tempA - tempColumn + 1;
        int column = tempColumn - 1;

        int sub = n - a;
        if(column % 2 == 0){
            System.out.println((sub+1) + "/" + (column - sub));
        } else {
            System.out.println((column - sub) + "/" + (sub+1) );
        }

    }
}