class Solution {
    static int[] answer = new int[2];

    // 압축 가능 한지 체크 x,y: 시작포인트 , size : 탐사 범위 큰범위부터 작은 범위로
    static boolean check(int x, int y, int size , int[][] arr) {
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (arr[i][j] != arr[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void dq(int startX , int startY , int size , int[][] arr) {
        if (check(startX, startY, size, arr)) {
            answer[arr[startX][startY]]++;
            return;
        }
        dq(startX,startY,size/2,arr);
        dq(startX + size/2,startY,size/2,arr);
        dq(startX,startY + size/2,size/2,arr);
        dq(startX + size/2,startY + size/2,size/2,arr);
    }

    public int[] solution(int[][] arr) {
        int size = arr.length;
        dq(0,0,size,arr);
        return this.answer;
    }
}