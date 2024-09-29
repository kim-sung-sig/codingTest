import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        
        for(int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - 'a';
            if(arr[index] == -1) {
                arr[index] = i;
            }
        }
        
        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

}