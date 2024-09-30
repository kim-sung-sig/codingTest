class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxw = 0, maxh=0;
        // swap
        for (int i = 0; i < sizes.length; i++) {
            if( sizes[i][0]<sizes[i][1]){
                int tmp = 0;
                tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        // Find maxw, maxh
        for (int[] size : sizes){
            if(maxw <size[0]){
                maxw = size[0];
            }
            if(maxh < size[1]){
                maxh = size[1];
            }
        }

        //print
        answer = maxw * maxh;
        return answer;
    }
}