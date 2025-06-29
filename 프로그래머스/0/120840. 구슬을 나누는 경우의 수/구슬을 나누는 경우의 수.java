import java.util.*;

class Solution {
    Map<nCr, Integer> memo = new HashMap<>();

    public int solution(int balls, int share) {
        return combination(balls, share);
    }

    public int combination(int n, int r) {
        if (r == 0 || n == r) return 1;

        nCr key = new nCr(n, r);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int value = combination(n - 1, r - 1) + combination(n - 1, r);
        memo.put(key, value);

        return value;
    }
}


class nCr {
    int n;
    int r;

    public nCr(int n, int r) {
        this.n = n;
        this.r = r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof nCr)) return false;
        nCr other = (nCr) o;
        return n == other.n && r == other.r;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, r);
    }
}