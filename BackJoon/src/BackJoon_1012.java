import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_1012 {

	private static String NEW_LINE = "\n";
	private static String SPACE = " ";
	private static int [] dx = {0, 0, -1, 1};
	private static int [] dy = {1, -1, 0, 0};
	private static boolean [][] visit;
	private static boolean [][] placed;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			visit = new boolean[n][m];
			placed = new boolean[n][m];
		
			while(k-- > 0) {
				st = new StringTokenizer(br.readLine(), SPACE);
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				placed[y][x] = true;
			}
			int result = 0;
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < m; ++j) {
					if(visit[i][j] || !placed[i][j]) 
						continue;
					result++;
					bfs(new Point(j, i), m, n);
					
				}
			}
			sb.append(result).append(NEW_LINE);
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
	private static void bfs(Point p, int m, int n) {
		Queue<Point> que = new LinkedList<Point>();		
		que.offer(p);
		visit[p.y][p.x] = true;
		while(!que.isEmpty()) {
			Point cur = que.poll();
			for(int i = 0; i < 4; ++i) {
				int newX = cur.x + dx[i];
				int newY = cur.y + dy[i];
				if(newX < 0 || newY < 0 || newX >= m || newY >= n) continue;
				if(visit[newY][newX] || !placed[newY][newX]) continue;
				visit[newY][newX] = true;
				que.add(new Point(newX, newY));
			}
		}
	}

}
