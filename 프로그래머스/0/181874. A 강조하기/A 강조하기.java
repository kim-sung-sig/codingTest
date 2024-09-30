class Solution {
    public String solution(String myString) {
        StringBuffer sb = new StringBuffer();
        for(String s: myString.split("")) {
        	if(s.equals("a")) {
        		sb.append(s.toUpperCase());
        	} else if(s.equals("A")){
        		sb.append(s);
        	} else {
        		sb.append(s.toLowerCase());
        	}
        }
        return sb.toString();
    }
}