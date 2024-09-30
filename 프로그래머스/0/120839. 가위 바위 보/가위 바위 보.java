class Solution {
	public String solution(String rsp) {
		StringBuffer sb = new StringBuffer();
		for (char ch : rsp.toCharArray()) {
			sb.append(mm(ch));
		}
		return sb.toString();
	}

	public static String mm(char ch) {
		String answer = "";
		switch (ch) {
			case '2':
				answer = "0";
				break;
			case '0':
				answer = "5";
				break;
			case '5':
				answer = "2";
				break;
		}
		return answer;
	}
}