import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BackJoon_10026 {

	private static boolean [][] visit;
	private static int [] dx = { 0, 0, -1, 1};
	private static int [] dy = { 1, -1, 0, 0};
	private static char [] color = {'R', 'G', 'B'};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		char [][] map = new char[n][n];
		char [][] map2 = new char[n][n];
		
		for(int i = 0; i < n; ++i) {
			String str = br.readLine();
			for(int j = 0; j < n; ++j) {
				if(str.charAt(j) != 'B') map2[i][j] = 'R';
				else map2[i][j] =str.charAt(j);
				map[i][j] = str.charAt(j);
			}
		}
		StringBuilder sb = new StringBuilder();
		int result = 0;
		for(int k = 0; k < 3; ++k) {
			visit = new boolean[n][n];
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < n; ++j) {
					if(visit[i][j] || map[i][j] != color[k]) continue;
					result++;
					bfs(new Point(j, i), n, color[k], map);
				}
			}
		}
		sb.append(result).append(" ");
		result = 0;
		for(int k = 0; k < 3; ++k) {
			visit = new boolean[n][n];
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < n; ++j) {
					if(visit[i][j] || map2[i][j] != color[k]) continue;
					result++;
					bfs(new Point(j, i), n, color[k], map2);
				}
			}
		}
		sb.append(result);
		System.out.print(sb);
		
	}
	private static class Point{
		int x, y;
		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static void bfs(Point p, int n, char color, char [][] map) {
		Queue<Point> que = new LinkedList<Point>();
		que.offer(p);
		visit[p.y][p.x] = true;
		while(!que.isEmpty()) {
			Point cur = que.poll();
			
			for(int i = 0; i < 4; ++i) {
				int newX = cur.x + dx[i];
				int newY = cur.y + dy[i];
				if(newX < 0 || newY < 0 || newX >= n || newY >= n) continue;
				if(visit[newY][newX] || map[newY][newX] != color ) continue;
				visit[newY][newX] = true;
				que.add(new Point(newX, newY));
			}
		}
	}
}
