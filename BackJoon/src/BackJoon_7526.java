import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_7526 {

	private static int [][] map;
	private static boolean[][] visit;
	private static int [] dx = { 1, 1, -1, -1, 2, 2, -2, -2};
	private static int [] dy = { 2, -2, 2, -2, 1, -1, 1, -1};
	private static int INF = 90001;
	private static String NEW_LINE = "\n";
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		while(testCase-- > 0) {
			Point startPoint, endPoint;
			int l = Integer.parseInt(br.readLine());
			map = new int [l][l];
			visit = new boolean[l][l];
			StringTokenizer st = new StringTokenizer(br.readLine());
			startPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			endPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			sb.append(bfs(startPoint, endPoint, l, INF)).append(NEW_LINE);
			
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
	
	private static int bfs(Point st, Point end, int l, int min) {
		Queue<Point> que = new LinkedList<Point>();
		visit[st.y][st.x] = true;
		que.offer(st);
		
		while(!que.isEmpty()) {
			Point cur = que.poll();
			if(cur.y == end.y && cur.x == end.x) min = Math.min(min, map[cur.y][cur.x]);
			for(int i = 0; i < 8; ++i) {
				int newX = cur.x + dx[i];
				int newY = cur.y + dy[i];
				if(newX < 0 || newY < 0 || newX >= l || newY >= l) continue;
				if(visit[newY][newX]) continue; 
				visit[newY][newX] = true;
				map[newY][newX] = map[cur.y][cur.x] + 1; 
				que.add(new Point(newX, newY));
			}
		}
		
		return min;
	}
}
