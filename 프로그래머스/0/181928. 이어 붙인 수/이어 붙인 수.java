class Solution {
    public int solution(int[] num_list) {
        StringBuffer even = new StringBuffer();
        StringBuffer odd = new StringBuffer();
        for(int n : num_list) {
            if(n%2==0) {
                even.append(n);
            } else {
            	odd.append(n);
            }
        }
        int answer = Integer.parseInt(even.toString())+ Integer.parseInt(odd.toString());
        return answer;
    }
}