import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int count = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<moves.length ;i++) {
        	
        	for(int j =0; j< board.length; j++) {
        		
        		if(board[j][moves[i]-1] != 0) {
        			if(stack.isEmpty()) {
        				stack.push(board[j][moves[i]-1]);
        			} else {
        				if(stack.peek()==board[j][moves[i]-1]) {
        					stack.pop();
        					count+=2;
        				} else {
        					stack.push(board[j][moves[i]-1]);
        				}
        			}
        			board[j][moves[i]-1] = 0; // 꺼냇다.
        			break; //한트랙끝
        		}
        	}
        }
        
        return count;
    }
}