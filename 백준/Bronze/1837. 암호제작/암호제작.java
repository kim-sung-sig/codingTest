import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] pk = br.readLine().split(" ");

        BigInteger p = new BigInteger(pk[0]);
        int k = Integer.parseInt(pk[1]);

        // 소수 목록을 구하는 에라토스테네스의 체
        boolean[] isPrime = new boolean[k];
        for (int i = 2; i < k; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= k; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < k; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // System.out.println(Arrays.toString(isPrime));

        // 소수 리스트에 넣기
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < k; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // 소수로 나누어지는지 확인
        int r = 0;
        for (int prime : primes) {
            if (p.mod(BigInteger.valueOf(prime)).equals(BigInteger.ZERO)) {
                r = prime;
                break;
            }
        }

        if(r == 0) {
            System.out.println("GOOD");
        } else {
            System.out.println("BAD " + r);
        }
    }
}
