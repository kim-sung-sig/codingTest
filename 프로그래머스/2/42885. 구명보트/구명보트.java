import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Integer[] peop = new Integer[people.length];
        Arrays.sort(people);
        for(int i =0 ; i < people.length; i++) {
        	peop[i] = (Integer) people[i];
        }
        
        
        List<Integer> list =new ArrayList<>(Arrays.asList(peop));
        for(int i =0; i<people.length; i++) {
        	if(list.isEmpty()) {
        		break;
        	}
        	if( list.get(0) + list.get(list.size()-1) <=limit) {
        		list.remove(list.size()-1);
        		if(!list.isEmpty()) {
        			list.remove(0);        			
        		}
        		answer ++;
        	} else {
        		list.remove(list.size()-1);
        		answer ++;
        	}
        }
        
        return answer;
    }
}