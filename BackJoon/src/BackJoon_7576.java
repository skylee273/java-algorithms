import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_7576 {

	private static int[][] tomato;
	private static boolean[][] visited;
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static int M;
	private static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

	
		tomato = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
	}

	private static class Point {
		public int x, y;

		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void bfs() {
		Queue<Point> que = new LinkedList<Point>();

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j)
				if (tomato[i][j] == 1) {
					que.add(new Point(j, i));
					visited[i][j] = true;
				}
		}
		while (!que.isEmpty()) {
			Point p = que.poll();
			for (int i = 0; i < 4; ++i) {
				int newX = p.x + dx[i];
				int newY = p.y + dy[i];
				if (newX >= M || newY >= N || newX < 0 || newY < 0)
					continue;

				if (tomato[newY][newX] == 0 && visited[newY][newX] == false) {
					que.add(new Point(newX, newY));
					tomato[newY][newX] = tomato[p.y][p.x] + 1;
					visited[newY][newX] = true;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, tomato[i][j]);
			}
		}
		System.out.println(max - 1);

	}

}
