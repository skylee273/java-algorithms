package Sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BackJoon_11650 {

	private static String NEW_LINE = "\n";
	private static String SPACE = " ";
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point [] arr = new Point[n];
		
		for(int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Point(x, y);
		}
		Arrays.sort(arr, Point.comparator);
		StringBuilder sb = new StringBuilder();
		for(Point p : arr) {
			sb.append(p.x).append(SPACE).append(p.y).append(NEW_LINE);
		}
		System.out.print(sb);
	}
	
	private static class Point{
		public int x;
		public int y;
		
		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		private static Comparator<Point> comparator = new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				if(o1.x < o2.x) return -1;
				else if(o1.x == o2.x) {
					if(o1.y < o2.y) return -1;
				}
				return 1;
			}
		};
	}

}
