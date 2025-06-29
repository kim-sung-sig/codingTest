import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] sets = s.split("},\\{");

        Arrays.sort(sets, Comparator.comparingInt(String::length));

        // System.out.println(Arrays.toString(sets));

        List<String> result = new ArrayList<>();
        Set<String> mem = new HashSet<>();

        for (String set : sets) {
            String[] nums = set.split(",");
            for (String num : nums) if (mem.add(num)) result.add(num);
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}