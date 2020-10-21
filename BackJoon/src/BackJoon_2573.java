import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BackJoon_2573 {

	private static int n, m;
	private static int [] dx = {0, 0, -1, 1};
	private static int [] dy = {1, -1, 0, 0};
	private static int [][] map;
	private static int [][] melt;
	private static boolean [][] visit;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		melt = new int[n][m];
		
		
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
		while(true) {
			visit = new boolean[n][m];
			int cnt = 0;
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < m; ++j) {
					if(!visit[i][j] && map[i][j] != 0) {
						bfs(new Point(j, i));
						cnt++;
					}
				}
			}
			if(cnt == 0) {
				System.out.println(0);
				break;
	        } else if(cnt >= 2) {
	        	System.out.println(year);
	        	break;
	        }
			
			melt();
			year++;
		}
	}

	private static class Point{
		int x, y;
		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void bfs(Point p) {
		Queue<Point> que = new LinkedList<Point>();
		que.add(p);
		visit[p.y][p.x] = true;
		while(!que.isEmpty()) {
			Point cur = que.poll();
			
			for(int i = 0; i < 4; ++i) {
				int newX = cur.x + dx[i];
				int newY = cur.y + dy[i];
				if(newX < 0 || newY < 0 || newX >= m || newY >= n) continue;
				if(map[newY][newX] == 0) melt[cur.y][cur.x]++;
				if(visit[newY][newX] || map[newY][newX] == 0) continue;
				visit[newY][newX] = true;
				que.add(new Point(newX, newY));
			}
		}	
	}
	private static void melt() {
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				map[i][j] -= melt[i][j];
				if(map[i][j] < 0) map[i][j] = 0;
				melt[i][j] = 0;
			}
		}
	}
}
