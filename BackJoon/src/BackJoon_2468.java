import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_2468 {

	private static int [][] map;
	private static int [][] copyMap;
	private static boolean [][] visit;
	private static boolean [] height = new boolean[101];
	private static int [] dx = { 0, 0, -1, 1};
	private static int [] dy = { 1, -1, 0, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int max = 0, min = 101;
		for(int i = 0; i < n; ++i ) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > max) max = map[i][j];
				if(map[i][j] < min) min = map[i][j];
			}
		}
		int cnt = 1;
		for(int h = min; h <= max; ++h) {
			visit = new boolean[n][n];
			int result = 0;
			for(int i = 0; i <n; ++i) {
				for(int j = 0; j < n; ++j) {
					if(visit[i][j] || map[i][j] <= h)continue;
					result++;
					bfs(new Point(j, i), h, n);
				}
			}
			cnt = Math.max(result, cnt);
		}
		
		System.out.print(cnt);
		
	}
	private static class Point{
		int x, y;
		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static void bfs(Point p , int height, int n) {
		Queue<Point> que = new LinkedList<Point>();
		visit[p.y][p.x] = true;
		que.offer(p);
		
		while(!que.isEmpty()) {
			Point cur = que.poll();
			
			for(int i = 0; i < 4; ++i) {
				int newX = cur.x + dx[i];
				int newY = cur.y + dy[i];
				if(newX < 0 || newY < 0 || newX >= n || newY >= n) continue;
				if(visit[newY][newX] || map[newY][newX] <= height) continue;
				visit[newY][newX] = true;
				que.add(new Point(newX, newY));
			}
		}
		
	}

}
