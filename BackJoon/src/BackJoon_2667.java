import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BackJoon_2667 {

	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static int[][] map;
	private static boolean[][] visited;
	private static int N;
	private static String NEW_LINE = "\n";
	private static int cnt = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			for (int j = 0; j < N; ++j) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] != 0 && visited[i][j] == false) {
					cnt = 1;
					bfs(new Point(j, i));
					list.add(cnt);
				}
			}
		}

		sb.append(list.size()).append(NEW_LINE);
		Collections.sort(list);
		for (int ans : list) {
			sb.append(ans).append(NEW_LINE);
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

	private static void dfs(Point current) {
		if (visited[current.y][current.x])
			return;
		visited[current.y][current.x] = true;

		for (int i = 0; i < 4; ++i) {
			int newX = current.x + dx[i];
			int newY = current.y + dy[i];

			if (newX >= N || newY >= N || newX < 0 || newY < 0)
				continue;
			if (visited[newY][newX])
				continue;

			if (map[newY][newX] != 0) {
				dfs(new Point(newX, newY));
				cnt++;
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

				if (newX >= N || newY >= N || newX < 0 || newY < 0)
					continue;
				if (visited[newY][newX])
					continue;
				if (map[newY][newX] != 0) {
					visited[newY][newX] = true;
					cnt++;
					que.add(new Point(newX, newY));
				}
			}
		}
	}
}
