import java.util.stream.IntStream;
class Solution {
    public int solution(String t, String p) {
    	int sizeOfP = p.length();
    	
    	int answer = (int) IntStream.range(0, t.length() - sizeOfP + 1)
    						        .mapToObj(i -> t.substring((int) i, (int) i + sizeOfP))
    						        .filter(a -> a.compareTo(p) <= 0)
    						        .count();
        return answer;
    }
}