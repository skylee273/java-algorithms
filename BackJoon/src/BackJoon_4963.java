import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_4963 {

	private static int[] dx = { 0, 0, -1, -1, -1, 1, 1, 1 };
	private static int[] dy = { 1, -1, -1, 1, 0, -1, 1, 0 };
	private static int[][] map;
	private static boolean[][] visited;
	private static int w;
	private static int h;
	private static String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if(w == 0 && h == 0)
				break;
			
			map = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int land = 1;
			for (int i = 0; i < h; ++i) {
				for (int j = 0; j < w; ++j)
					if (map[i][j] == 1 && visited[i][j] == false)
						bfs(i, j, land++);
			}

			int max = 0;
			for (int i = 0; i < h; ++i) {
				for (int j = 0; j < w; ++j)
					max = Math.max(max, map[i][j]);
			}
			sb.append(max).append(NEW_LINE);
		}
		System.out.print(sb);
	}

	private static class Point {
		public int x;
		public int y;

		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	private static void bfs(int y, int x, int land) {
		Queue<Point> que = new LinkedList<Point>();

		if (visited[y][x])
			return;

		visited[y][x] = true;
		map[y][x] = land;
		
		que.offer(new Point(x, y));

		while (!que.isEmpty()) {
			Point p = que.poll();
			for (int i = 0; i < 8; ++i) {
				int newX = p.x + dx[i];
				int newY = p.y + dy[i];

				if (newX >= w || newY >= h || newX < 0 || newY < 0)
					continue;

				if (visited[newY][newX])
					continue;

				if (map[newY][newX] != 0) {
					que.add(new Point(newX, newY));
					visited[newY][newX] = true;
					map[newY][newX] = land;
				}

			}

		}
	}

}
