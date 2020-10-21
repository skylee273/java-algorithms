import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_9205 {

	private static boolean [] visited;
	private static final int MAX_DIST = 1_000;
	private static String SUCCESS = "happy";
	private static String FAIL = "sad";
	private static String NEW_LINE = "\n";
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		while(testCase-- > 0) {
			int n  = Integer.parseInt(br.readLine());
			Point[] location = new Point[n+2];
			visited = new boolean[n+2];
			for(int i = 0; i < n+2; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				location[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			Point st = location[0];
			Point dest = location[n+1];
			sb.append(bfs(st, dest, location, n) == true ? SUCCESS : FAIL).append(NEW_LINE);
		}
		System.out.print(sb);
	}

	private static class Point{
		int x, y;
		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static boolean bfs(Point st, Point dest, Point[] locations, int n) {
		Queue<Point> que = new LinkedList<Point>();
		que.offer(st);
		
		while(!que.isEmpty()) {
			Point cur = que.poll();
			if(cur.equals(dest)) return true;
			for(int i = 1; i < n+2; ++i) {
				int dist = Math.abs(cur.x - locations[i].x) +  Math.abs(cur.y - locations[i].y);
				if(visited[i] || dist > MAX_DIST) continue;
				visited[i] = true;
				que.add(locations[i]);
			}
		}
		return false;
	}
}
