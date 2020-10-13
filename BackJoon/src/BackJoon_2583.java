import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_2583 {

	private static boolean[][] placed;
	private static boolean[][] visit;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static String SPACE = " ";
	private static String NEW_LINE = "\n";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		placed = new boolean[m][n];
		visit  = new boolean[m][n];
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine() , " ");
			int leftX = Integer.parseInt(st.nextToken());
			int rightY = m - Integer.parseInt(st.nextToken());
			int rightX = Integer.parseInt(st.nextToken());
			int leftY = m - Integer.parseInt(st.nextToken());

			for (int i = leftY; i < rightY; ++i) {
				for (int j = leftX; j < rightX; ++j) {
					placed[i][j] = true;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		List<Integer> list =new ArrayList<Integer>();
		int result = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m ; ++j) {
				if (!visit[j][i] && !placed[j][i]) {
					result++;
					list.add(bfs(new Point(i, j), m, n, 0));
				}
			}	
		}
		sb.append(result).append(NEW_LINE);
		Collections.sort(list);
		for(int val : list) {
			sb.append(val).append(SPACE);
		}
		
		System.out.print(sb);

	}

	private static class Point {
		int x, y;

		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int bfs(Point p, int m, int n, int result) {
		Queue<Point> que = new LinkedList<Point>();
		que.offer(p);
		visit[p.y][p.x] = true;
		while (!que.isEmpty()) {
			Point cur = que.poll();
			result++;
			for (int i = 0; i < 4; ++i) {
				int newX = cur.x + dx[i];
				int newY = cur.y + dy[i];
				if (newX < 0 || newY < 0 || newX >= n  || newY >= m) continue;
				if (visit[newY][newX] || placed[newY][newX]) continue;
				visit[newY][newX] = true;
				que.add(new Point(newX, newY));
			}
		}
		return result;
	}

}
