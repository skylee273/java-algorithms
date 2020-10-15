import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_1987 {

	private static int [][] map;
	private static boolean [][] visit;
	private static boolean [] visited;
	private static int [] dx = { 0, 0, -1, 1};
	private static int [] dy = { 1, -1, 0, 0};
	private static int max = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		map = new int [r][c];
		visit = new boolean[r][c];
		visited =  new boolean[27];
		for(int i = 0; i < r; ++i) {
			String str = br.readLine();
			for(int j = 0; j < c; ++j) {
				map[i][j] = (int)(str.charAt(j) - 'A');
			}
		}
		dfs(new Point(0, 0, 1), r, c);
		System.out.print(max);
	
		
		
	}
	
	private static class Point{
		int x, y, step;
		private Point(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}

	
	private static void dfs(Point p, int r, int c) {
		
		max = Math.max(max, p.step);
		visit[p.y][p.x] = true; visited[map[p.y][p.x]] = true;
		
		for(int i = 0; i < 4; ++i) {
			int newX = p.x + dx[i];
			int newY = p.y + dy[i];
			if(newY >= r || newX >= c || newX < 0 || newY < 0) continue;
			if(visit[newY][newX] || visited[map[newY][newX]]) continue;
			visit[newY][newX] = true; visited[map[newY][newX]]= true;
			dfs(new Point(newX, newY, p.step + 1), r, c);
			visit[newY][newX] = false; visited[map[newY][newX]]= false;
		}
		
	}
}
