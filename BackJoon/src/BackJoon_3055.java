import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_3055 {

	private static char[][] map;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static char WATER = '*';
	private static char START = 'S';
	private static char DESTINATION = 'D';
	private static char OBSTACLE = 'X';
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
	
		for (int i = 0; i < r; ++i) {
			map[i] = br.readLine().toCharArray();
		}
		int ans = bfs(r, c);
		System.out.print(ans == -1 ? "KAKTUS" : ans);
		
	}

	private static class Point {
		int x, y, step;
		char c;

		private Point(int x, int y, int step, char c) {
			this.x = x;
			this.y = y;
			this.step = step;
			this.c = c;
		}
	}

	// *은 . 일때만 이동 시키자.
	private static int bfs(int r, int c) {
		Queue<Point> que = new LinkedList<>();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
               if(map[i][j] == WATER) que.add(new Point(j, i, 0, WATER));
            }
        }
         
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
            	if(map[i][j] == START) que.add(new Point(j, i, 0, START));
            }
        }
		
		while (!que.isEmpty()) {
			Point cur = que.poll();
			for (int i = 0; i < 4; ++i) {
				int newX = cur.x + dx[i];
				int newY = cur.y + dy[i];
				if (newX < 0 || newY < 0 || newX >= c || newY >= r) continue;
				if(cur.c == START) {
					if(map[newY][newX] == START || map[newY][newX] == WATER || map[newY][newX] == OBSTACLE) continue;
					if(map[newY][newX] == DESTINATION) return cur.step + 1;
					map[newY][newX] = START;
					que.add(new Point(newX, newY, cur.step + 1, START));
					continue;
				}
				if(cur.c == WATER) {
					if(map[newY][newX] == WATER || map[newY][newX] == OBSTACLE ||  map[newY][newX] == DESTINATION) continue;
					map[newY][newX] = WATER;
					que.add(new Point(newX, newY, cur.step, WATER));
				}
			}
			
		}
		return -1;
	}

}
