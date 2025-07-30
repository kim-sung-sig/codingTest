class Solution {
	public int solution(int n, int w, int num) {
		int answer = 0;

		int floor = (num - 1) / w + 1; // 물건의 층수
		int tempIndex = (num - 1) % w;
		int index = floor % 2 == 0 ? (w - 1) - tempIndex : tempIndex;

		int totalFloors = (n - 1) / w + 1; // 최고층수
		int lastTempIndex = (n - 1) % w;
		int lastIndex = totalFloors % 2 == 0 ? (w - 1) - lastTempIndex : lastTempIndex;

		// 최고층인 경우
		if (floor == totalFloors) return 1;

		int k = (totalFloors % 2 == 0 && index < lastIndex) || (totalFloors % 2 == 1 && lastIndex < index) ? -1 : 0;
		return totalFloors - floor + 1 + k;
	}
}