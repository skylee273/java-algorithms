import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_7569 {

	private static int [][][] map;
	private static boolean [][][] visit;
	private static int [] dx = {0, 0, 1, -1, 0, 0};
	private static int [] dy = {1, -1, 0, 0, 0 ,0};
	private static int [] dz = {0, 0, 0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		map = new int [h][n][m];
		visit = new boolean[h][n][m];
		Queue<Point> que = new LinkedList<Point>();
		for(int k = 0; k < h; ++k) {
			for(int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; ++j) {
					map[k][i][j] = Integer.parseInt(st.nextToken());
					if(map[k][i][j] == 1) que.add(new Point(j, i, k));
				}
			}
		}
	
		bfs( h, m, n);
	
	}
	
	
	private static class Point{
		int x, y, z;
		private Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	private static void bfs(int h, int m, int n) {
		Queue<Point> que = new LinkedList<Point>();
		
		for(int k = 0; k < h; ++k) {
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < m; ++j) {
					if(map[k][i][j] == 1) {
						que.add(new Point(j, i, k));
						visit[k][i][j] = true;
					}
				}
			}
		}
		
		while(!que.isEmpty()) {
			Point cur = que.poll();
			for(int i = 0; i < 6; ++i) {
				int newX  = cur.x + dx[i];
				int newY = cur.y + dy[i];
				int newZ = cur.z + dz[i];
				
				if(newX < 0 || newY < 0 || newZ < 0 || newX >= m || newY >= n || newZ >= h) continue;
				if(visit[newZ][newY][newX] || map[newZ][newY][newX] != 0) continue;
				visit[newZ][newY][newX] = true;
				map[newZ][newY][newX] = map[cur.z][cur.y][cur.x] + 1;
				que.add(new Point(newX, newY, newZ));
				
			}
		}
		
		int max = 0;
		
		for(int k = 0; k < h; ++k) {
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < m; ++j) {
					if(map[k][i][j] == 0) {
						System.out.println(-1);
						return;
					}
					max = Math.max(max, map[k][i][j]);
				}
			}
		}
		System.out.println(max - 1);
		
	}

	
}
