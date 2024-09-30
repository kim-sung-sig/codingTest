import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        int[] aaa = new int[3];
        for(int i=0 ; i<nums.length-2 ; i++){
            for(int j=1 ; j<nums.length-1;j++){
                if(i>=j){continue;}
                for(int k=2 ; k < nums.length ; k++){
                    if(j>=k){continue;}
                    aaa[0]=nums[i];
                    aaa[1]=nums[j];
                    aaa[2]=nums[k];
                    boolean qqq = true;
                    int jg = nums[i] + nums[j] + nums[k];
                    for (int l = 2; l <= jg/2; l++) {
                        if( (jg % l) == 0){
                            qqq=false;
                        }
                    }
                    if(qqq){answer++;}
                }
            }
        }
        return answer;
    }
}