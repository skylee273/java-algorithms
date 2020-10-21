import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BackJoon_1937 {

	private static int [] dx = { 0, 0, -1, 1};
	private static int [] dy = { 1, -1, 0, 0};
	private static int [][] visited;
	private static int [][] map;
	private static int n;
	private static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new int[n][n];
		
		for(int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; ++i)
			for(int j = 0; j < n; ++j) {
				if(visited[i][j] != 0) continue;
				max = Math.max(max, dfs(new Point(j, i)));

			}
		
		
		System.out.print(max);
		
	}

	private static class Point{
		int x, y;
		
		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	private static int dfs(Point p) {
		if(visited[p.y][p.x] != 0) return visited[p.y][p.x];
		visited[p.y][p.x] = 1;
		for(int i = 0; i < 4; ++i) {
			int newX = p.x + dx[i];
			int newY = p.y + dy[i];
			if(newX < 0 || newY < 0 || newX >= n || newY >= n ) continue;
			if(map[newY][newX] <=  map[p.y][p.x]) continue;
			visited[p.y][p.x] = Math.max(visited[p.y][p.x], dfs(new Point(newX, newY)) + 1);
		}
		return visited[p.y][p.x];
	}
}
