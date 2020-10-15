import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_2589 {

	private static char [][] map;
	private static boolean [][] visit;
	private static char LAND = 'L';
	private static char WATER = 'W';
	private static int [] dx = {0, 0, 1, -1};
	private static int [] dy = {1, -1, 0, 0};
	private static int max = 0;
	private static ArrayList<Point> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		list = new ArrayList<Point>();
		for(int i = 0; i < r; ++i) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < c; ++j)
				if(map[i][j] == LAND) list.add(new Point(j, i, 0));
		}
		
		
		bfs(r, c);
		
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
	
	private static void bfs(int r, int c) {
		
		for(Point  p : list) {
			visit = new boolean[r][c];
			Queue<Point> que = new LinkedList<Point>();
			visit[p.y][p.x] = true; que.offer(p);	
			while(!que.isEmpty()) {
				Point cur = que.poll();
				max = Math.max(max, cur.step);
				for(int i = 0; i < 4; ++i) {
					int newX = cur.x + dx[i];
					int newY = cur.y + dy[i];
					if(newX < 0 || newY < 0 || newX >= c || newY >= r)continue;
					if(visit[newY][newX] || map[newY][newX] == WATER) continue;
					visit[newY][newX] = true;
					que.add(new Point(newX, newY, cur.step + 1));
				}
			}
		}
	}

}
