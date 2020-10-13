	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.StringTokenizer;
	
	public class BackJoon_1697 {
	
		private static String SPACE = " ";
		private static int max = 0;
		private static boolean [] visit;
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			visit = new boolean[100001];
			System.out.print(bfs(n,k));
			
		}
		
		private static class Point{
			int x, step;
			private Point(int x, int step) {
				this.x = x;
				this.step = step;
			}
		}
		private static int bfs(int n, int k) {
			Queue<Point> que = new LinkedList<Point>();
			
			if(n == k) return 0;
			visit[n] = true;
			que.offer(new Point(n, 0));
			
			while(!que.isEmpty()) {
				Point p = que.poll();
				int [] dx = {p.x * 2,  p.x + 1, p.x -1};
				if(p.x == k) {max = Math.max(p.step, max); return max;}
				for(int newX : dx) {
					if(newX < 0 || newX > 100000 || visit[newX]) continue;
					visit[p.x] = true;
					que.add(new Point(newX, p.step + 1));
				}
			}
			
			return 0;
		}
	
	}
