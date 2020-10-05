import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_2146 {

	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static int N;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] == 1) {
					visited = new boolean[N][N];
					dfs(new Point(j, i, 0));
					bfs(new Point(j, i, 0));
				}
					
			}
		}

		System.out.print(min);
	}

	private static class Point {
		public int x;
		public int y;
		public int cnt;

		private Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	private static void bfs(Point current) {
		Queue<Point> que = new LinkedList<Point>();
		que.add(new Point(current.x, current.y, current.cnt));

		while (!que.isEmpty()) {
			Point p = que.poll();
			for (int i = 0; i < 4; ++i) {
				int newX = p.x + dx[i];
				int newY = p.y + dy[i];
				if (newX < 0 || newY < 0 || newX >= N || newY >= N)
					continue;
				if (visited[newY][newX])
					continue;

				if (map[newY][newX] == 0) {
					visited[newY][newX] = true;
					que.add(new Point(newX, newY, p.cnt + 1));
				} else if (map[newY][newX] == 1 && p.cnt > 0)
					min = Math.min(min, p.cnt);
			}
		}
	}

	private static void dfs(Point current) {
		if (visited[current.y][current.x])
			return;
		visited[current.y][current.x] = true;
		for (int i = 0; i < 4; ++i) {
			int newX = current.x + dx[i];
			int newY = current.y + dy[i];
			if (newX < 0 || newY < 0 || newX >= N || newY >= N)
				continue;
			if (visited[newY][newX])
				continue;
			if (map[newY][newX] == 1) {
				dfs(new Point(newX, newY, current.cnt));
			}
		}
	}

}
