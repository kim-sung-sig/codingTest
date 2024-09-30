class Solution {
	static int count = 0;
    public int solution(String myString, String pat) {
    	myString = myString.replaceAll("A", "X");
        myString = myString.replaceAll("B", "A");
        myString = myString.replaceAll("X", "B");
        if(myString.contains(pat)) return 1;
        return 0;
    }
}