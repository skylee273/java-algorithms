import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_5014 {

	private static int[] move = new int[2];
	private static int[] visit;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		move[0] = Integer.parseInt(st.nextToken());
		move[1] = Integer.parseInt(st.nextToken());

		visit = new int[F + 1];
		
		System.out.print(bfs(F, S, G));
	
	}


	private static String bfs(int maxFloor, int startFloor, int GoalFloor) {
		Queue<Integer> que = new LinkedList<Integer>();
		visit[startFloor] = 1;
		que.offer(startFloor);
		while (!que.isEmpty()) {
			int cur = que.poll();
			if (cur == GoalFloor) return String.valueOf(visit[cur]-1);
			for(int i = 0; i < 2; ++i) {
				int nextPoint = i == 0 ? cur + move[i] : cur - move[i];
				if(nextPoint > maxFloor || nextPoint < 1) continue;
				if(visit[nextPoint] != 0) continue;
				visit[nextPoint] = visit[cur] + 1;
				que.add(nextPoint);
			}
		}
		return "use the stairs";
		
	}

	

}
