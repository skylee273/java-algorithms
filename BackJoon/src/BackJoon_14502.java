import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_14502 {

	private static int [][] map;
	private static List<Point> virusList;
	private static int [] dx = { 0, 0, -1, 1};
	private static int [] dy = { 1, -1, 0, 0};
	private static final int BLOCK = 1;
	private static final int VIRUS = 2;
	private static final int BLANK = 0;
	private static int safeCnt = 0;
	private static int n,m;
	private static int safeMaxArea = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int [n][m];
		virusList = new ArrayList<Point>();
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] ==  VIRUS) virusList.add(new Point(j, i));
				else if(map[i][j] == BLANK) safeCnt++;
			}
		}
		dfs(new Point(0, 0), 0);
		System.out.print(safeMaxArea-3);
		
	}
	private static class Point{
		int x, y;
		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static void dfs(Point p, int cnt) {
		if(cnt == 3) { bfs(new boolean[n][m]); return; }
		
		for(int i = 0; i < n; ++i)
			for(int j = 0; j < m; ++j) {
				if(map[i][j] != BLANK) continue;
				map[i][j] = BLOCK;
				dfs(new Point(j, i), cnt + 1);
				map[i][j] = BLANK;
			}
	}
	private static void bfs(boolean [][] visit) {
		Queue<Point> que = new LinkedList<Point>();
		int safeArea = safeCnt;
		for(Point v : virusList) {
			visit[v.y][v.x] = true; que.add(v);
		}
		
		while(!que.isEmpty()) {
			Point cur = que.poll();
			for(int i = 0; i < 4; ++i) {
				int newX = cur.x + dx[i];
				int newY = cur.y + dy[i];
				if(newX < 0 || newY < 0 || newX >= m || newY >= n) continue;
				if(visit[newY][newX] || map[newY][newX] != BLANK) continue;
				visit[newY][newX] = true;
				que.add(new Point(newX, newY));
				safeArea--;
			}
		}
		safeMaxArea = Math.max(safeMaxArea, safeArea);	
	}
}
