public class Main {
    
    private static int[] arr = new int[10001];

    public static void main(String[] args) throws Exception {
        int n = 1;
        while(n <= 10000) {
            if(arr[n] == 1) {
                n++;
                continue;
            }
            findUnSelfNumber(n);
            n++;
        }

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == 0) {
                System.out.println(i);
            }
        }
    }

    public static void findUnSelfNumber(int n) {
        int sum = n;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }

        if(sum <= 10000) {
            arr[sum] = 1;
            findUnSelfNumber(sum);
        }
    }

}