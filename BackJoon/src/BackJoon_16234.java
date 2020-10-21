import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BackJoon_16234 {

	private static int [][] map;
	private static int[][] isVisited;
	private static int [] total;
	private static int [] count;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static int n,l,r;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		while(bfs()) count++;
		System.out.print(count);
		
		
	}

	private static class Point {
		int x, y;

		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	
	private static boolean bfs() {
		isVisited = new int[n][n];
		total = new int [n*n + 1];
		count = new int [n*n + 1];
		boolean isMove = false;
		int union = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; ++j) {
				if(isVisited[i][j] != 0) continue;
				union++;
				Queue<Point> que =new LinkedList<Point>();
				
				que.offer(new Point(j, i));
				
				isVisited[i][j] = union;
				total[union] += map[i][j];
				count[union]++;
				
				while(!que.isEmpty()) {
					Point cur = que.poll();
					for(int k = 0; k < 4; ++k) {
						int newX = cur.x + dx[k];
						int newY = cur.y + dy[k];
						if(newX < 0 || newY < 0 || newX >= n || newY >= n) continue;
						int diff = Math.abs(map[cur.y][cur.x] - map[newY][newX]);
						if(isVisited[newY][newX] != 0 || diff < l || diff > r) continue;
						isVisited[newY][newX] = union;
						total[union] += map[newY][newX];
						count[union]++;
						isMove = true;
						que.add(new Point(newX, newY));
					}
				}
			}
		}
		cacl();
		return isMove ? true : false;
	}
	private static void cacl() {		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int idx = isVisited[i][j];
				map[i][j] = total[idx] / count[idx];
			}
		}
	}
}
