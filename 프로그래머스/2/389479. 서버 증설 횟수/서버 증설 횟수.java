import java.util.ArrayList;
import java.util.List;

class Solution {
	public int solution(int[] players, int m, int k) {
		int answer = 0;

		List<Server> servers = new ArrayList<>();

		for (int time = 0; time < players.length; time++) {
			int request = players[time];

			var it = servers.iterator();
			while (it.hasNext()) {
				Server server = it.next();
				if (server.getActiveHour(time) >= k) it.remove();
			}

//			int currentServerSize = servers.size();
			int capacity = (servers.size() + 1) * m;

			// 필요 시 서버 증설
			while (capacity <= request) {
				servers.add(new Server(time));
				answer++;
				capacity += m;
			}

//			System.out.println("[" + time + "시간차] 요청: " + request + ", 서버 수: " + servers.size() + ", 증설한 서버 수: " + (servers.size() - currentServerSize));
		}

		return answer;
	}
}

class Server {
	final int createdHour;
	Server(int createdHour) {
		this.createdHour = createdHour;
	}
	int getActiveHour(int currentHour) {
		return currentHour - createdHour;
	}
}