import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BackJoon_11650 {

	static int n;
	static Point[] array;
	static String SPACE = " ";
	static String NEW_LINE = "\n";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		array = new Point[n];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			array[i] = new Point(x, y);
		}

		Arrays.sort(array, Point.comparator);
		StringBuilder sb = new StringBuilder();
		for (Point p : array) {
			sb.append(p.x).append(SPACE).append(p.y).append(NEW_LINE);
		}
		System.out.print(sb.toString());
	}

	private static class Point {

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
				if (o1.x > o2.x)
					return 1;
				else if (o1.x == o2.x) {
					if (o1.y > o2.y)
						return 1;
				}
				return -1;
			}

		};

	}

}
