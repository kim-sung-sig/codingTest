import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < N; right++) {
            int current = arr[right];
            map.compute(current, (k, v) -> (v == null) ? 1 : v + 1);

            while (map.size() > 2) {
                int key = arr[left++];
                map.compute(key, (k, v) -> v - 1);
                if (map.get(key) == 0) map.remove(key);
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }

    /*
    static int min2 = Integer.MAX_VALUE;
    static Map<Integer, Integer> map = new HashMap<>();
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.compute(num, (k, v) -> (v == null) ? 1 : v + 1);
            deque.add(num);
        }

        if (map.keySet().size() <= 2) min2 = 0;
        else backtracking(0);

        System.out.println(N - min2);
    }

    static void backtracking(int cnt) {
        if (cnt >= min2) return;

        int first = deque.pollFirst();
        check(first, cnt + 1);
        deque.addFirst(first);

        int last = deque.pollLast();
        check(last, cnt + 1);
        deque.addLast(last);
    }

    static void check(Integer key, int cnt) {
        Integer value = map.get(key);
        if (value == 1) map.remove(key);
        else map.put(key, value - 1);

        if (map.keySet().size() == 2) min2 = Math.min(min2, cnt);
        else backtracking(cnt);

        if (value == 1) map.put(key, 1);
        else map.put(key, value);
    }
    */

}