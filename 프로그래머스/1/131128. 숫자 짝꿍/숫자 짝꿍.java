import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] x= new int[10], y= new int[10];
        for (int i = 0; i < X.length(); i++) {
            x[X.charAt(i)-48] += 1;
        };
        for (int i = 0; i < Y.length(); i++) {
            y[Y.charAt(i)-48] += 1;
        }; 

        int[] che = new int[10];
        for (int i = 0; i < 10; i++) {
            che[i] = Math.min(x[i],y[i]);
        };
        
        //출력
        if(che[0]==0&&che[1]==0 && che[2]==0 && che[3]==0 && che[4]==0 &&che[6]==0&&che[7]==0&&che[8]==0 &&che[9]==0){
            return "-1";
        }else if (che[1]==0 && che[2]==0 && che[3]==0 && che[4]==0 &&che[6]==0&&che[7]==0&&che[8]==0 &&che[9]==0){
            return "0";
        }
        else {
            for (int i = 9; i >=0 ; i--) {
                if( che[i] != 0){
                    String k = String.valueOf(i);
                    answer += k.repeat(che[i]);
                }
            };
            return answer;
        }
    }
}