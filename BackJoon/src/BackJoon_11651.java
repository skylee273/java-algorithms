import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BackJoon_11651 {

	static String SPACE = " ";
	static String NEW_LINE = "\n";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point[] array = new Point[n];

		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			array[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(array, Point.comparator);

		StringBuilder sb = new StringBuilder();
		for (Point pnts : array) {
			sb.append(pnts.x).append(SPACE).append(pnts.y).append(NEW_LINE);
		}
		System.out.print(sb.toString());
	}

	private static class Point {
		public int x, y;

		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		private static Comparator<Point> comparator = new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				// TODO Auto-generated method stub
				if (p1.y > p2.y)
					return 1;
				else if (p1.y == p2.y) {
					if (p1.x > p2.x) {
						return 1;
					}
				}
				return -1;
			}

		};
	}

}
