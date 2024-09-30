class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        String str = "";
        for(int i=0; i<todo_list.length ;i++) {
            if(!finished[i]) {
                str += todo_list[i] + " ";
            }
        }
        
        String[] answer = str.split(" ");
        return answer;
    }
}