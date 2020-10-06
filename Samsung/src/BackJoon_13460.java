import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_13460 {

	private static char[][] map;
	private static boolean[][][][] visited;
	private static int n;
	private static int m;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { -1, 1, 0, 0 };
	private static char BLOCK = '#';
	private static char RED = 'R';
	private static char BLUE = 'B';
	private static char HOLE = 'O';

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1][m + 1][n + 1][m + 1];
		map = new char[n][m];

		int rx = 0, ry = 0, bx = 0, by = 0;
		for (int i = 0; i < n; ++i) {
			String str = br.readLine();
			for (int j = 0; j < m; ++j) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == RED) {
					rx = j;
					ry = i;
				} else if (map[i][j] == BLUE) {
					bx = j;
					by = i;
				}
			}
		}
		System.out.print(bfs(new Point(rx, ry, bx, by, 0)));

	}

	private static int bfs(Point curPoint) {
		Queue<Point> que = new LinkedList<Point>();
		que.offer(new Point(curPoint.rx, curPoint.ry, curPoint.bx, curPoint.by, 0));
		visited[curPoint.ry][curPoint.rx][curPoint.by][curPoint.bx] = true;

		while (!que.isEmpty()) {
			Point p = que.poll();
			if (p.cnt > 10)
				continue;
			if (map[p.by][p.bx] == HOLE)
				continue;
			if (map[p.ry][p.rx] == HOLE)
				return p.cnt;

			for (int i = 0; i < 4; ++i) {
				int next_rx = p.rx;
				int next_ry = p.ry;
				while (true) {
					if (map[next_ry][next_rx] != HOLE && map[next_ry][next_rx] != BLOCK) {
						next_rx += dx[i];
						next_ry += dy[i];
					} else {
						if (map[next_ry][next_rx] == BLOCK) {
							next_rx -= dx[i];
							next_ry -= dy[i];
						}
						break;
					}

				}

				int next_bx = p.bx, next_by = p.by;
				while (true) {
					if (map[next_by][next_bx] != HOLE && map[next_by][next_bx] != BLOCK) {
						next_bx += dx[i];
						next_by += dy[i];
					} else {
						if (map[next_by][next_bx] == BLOCK) {
							next_bx -= dx[i];
							next_by -= dy[i];
						}
						break;
					}

				}
				if (next_rx == next_bx && next_ry == next_by) {
					if (map[next_ry][next_rx] != HOLE) {
						int red_cost = Math.abs(next_rx - p.rx) + Math.abs(next_ry - p.ry);
						int blue_cost = Math.abs(next_bx - p.bx) + Math.abs(next_by - p.by);
						if (red_cost > blue_cost) {
							next_rx -= dx[i];
							next_ry -= dy[i];
						} else {
							next_bx -= dx[i];
							next_by -= dy[i];
						}
					}
				}

				if (!visited[next_ry][next_rx][next_by][next_bx]) {
					visited[next_ry][next_rx][next_by][next_bx] = true;
					que.add(new Point(next_rx, next_ry, next_bx, next_by, p.cnt + 1));
				}
			}
		}
		return -1;
	}

	private static class Point {
		int rx;
		int ry;
		int bx;
		int by;
		int cnt;

		private Point(int rx, int ry, int bx, int by, int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}

	private static void printMap() {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
