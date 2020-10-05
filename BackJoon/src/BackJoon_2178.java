import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_2178 {

	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			for (int j = 0; j < M; ++j) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(new Point(0, 0));

		System.out.print(map[N - 1][M - 1]);
	}

	private static class Point {
		public int x;
		public int y;

		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void dfs(Point current) {
		if (visited[current.y][current.x])
			return;
		visited[current.y][current.x] = true;

		for (int i = 0; i < 4; ++i) {
			int newX = current.x + dx[i];
			int newY = current.y + dy[i];

			if (newX < 0 || newY < 0 || newX >= M || newY >= N)
				continue;
			if (visited[newY][newX])
				continue;
			if (map[newY][newX] != 0) {
				map[newY][newX] = map[current.y][current.x] + 1;
				visited[current.y][current.x] = true;
				dfs(new Point(newX, newY));
				visited[current.y][current.x] = false;
			}
		}
	}

	private static void bfs(Point current) {
		Queue<Point> que = new LinkedList<Point>();
		if (visited[current.y][current.x])
			return;
		visited[current.y][current.x] = true;
		que.offer(new Point(current.x, current.y));

		while (!que.isEmpty()) {
			Point p = que.poll();
			for (int i = 0; i < 4; ++i) {
				int newX = p.x + dx[i];
				int newY = p.y + dy[i];
				if (newX < 0 || newY < 0 || newX >= M || newY >= N)
					continue;
				if (visited[newY][newX])
					continue;

				if (map[newY][newX] != 0) {
					map[newY][newX] = map[p.y][p.x] + 1;
					visited[newY][newX] = true;
					que.add(new Point(newX, newY));
				}

			}
		}
	}
}
