import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_2206 {

	private static int [][] map;
	private static boolean [][][] visit;
	private static int [] dx = { 0, 0, -1, 1};
	private static int [] dy = { 1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[2][n][m];
		
		for(int i = 0; i < n; ++i) {
			String str = br.readLine();
			for(int j = 0; j < m; ++j) {
				map[i][j] = str.charAt(j) -'0';
			}
		}
		System.out.print(bfs(new Point(0, 0, 0, 0), n, m));
		
	}
	private static class Point{
		int x, y, step, block;
		private Point(int x, int y, int step, int block) {
			this.x = x;
			this.y = y;
			this.step = step;
			this.block = block;
		}
	}
	private static int bfs(Point p, int n, int m) {
		Queue<Point> que = new LinkedList<Point>();
		visit[0][p.y][p.x] = true;
		que.offer(p);
		
		while(!que.isEmpty()) {
			Point cur = que.poll();
			if(cur.y == n-1 && cur.x == m-1) {
				return cur.step + 1;
			}
			for(int i = 0; i < 4; ++i) {
				int newX = cur.x + dx[i];
				int newY = cur.y + dy[i];
				
				if(newX < 0 || newY < 0 || newX >= m || newY >= n) continue;
				if(map[newY][newX] == 1) {
					if(!visit[1][newY][newX] && cur.block == 0) { // 벽을 만났을때
						visit[1][newY][newX] = true;
						que.add(new Point(newX, newY, cur.step + 1, 1));
					}
				}
				else {
					if(!visit[cur.block][newY][newX]) {
						visit[cur.block][newY][newX] = true;
						que.add(new Point(newX, newY, cur.step+1, cur.block));
					}
				}
			}
		}
		return -1;
	}
}
