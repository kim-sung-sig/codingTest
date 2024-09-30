import java.util.Arrays;

class Solution {
	static int count = 0;
    public String[] solution(String[] names) {
    	return Arrays.stream(names).filter(x -> count++%5==0).toArray(String[]::new);
    }
}