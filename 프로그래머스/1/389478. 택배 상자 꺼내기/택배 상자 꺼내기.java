class Solution {
	public int solution(int n, int w, int num) {
		int answer = 0;

		int floor = (num - 1) / w + 1; // 물건의 층수
		int tempIndex = (num - 1) % w;
		int index = floor % 2 == 0 ? (w - 1) - tempIndex : tempIndex;

		int totalFloors = (n - 1) / w + 1; // 최고층수
		int lastTempIndex = (n - 1) % w;
		int lastIndex = totalFloors % 2 == 0 ? (w - 1) - lastTempIndex : lastTempIndex;

		if (floor == totalFloors) {
			// 최고층인 경우
			answer = 1;
		}
		else {
			int k;
			if (totalFloors % 2 == 0 && index < lastIndex) {
				k = -1;
			}
			else if (totalFloors % 2 == 1 && lastIndex < index) {
				k = -1;
			}
			else {
				k = 0;
			}
			answer = totalFloors - floor + 1 + k;
		}

		return answer;
	}
}