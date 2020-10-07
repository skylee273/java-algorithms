import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_1780 {

	private static int[][] map;
	private static int[] ans;
	private static String NEW_LINE = "\n";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		ans = new int[3];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, n);
		StringBuilder sb = new StringBuilder();
		sb.append(ans[0]).append(NEW_LINE).append(ans[1]).append(NEW_LINE).append(ans[2]);
		System.out.print(sb);
	}

	private static boolean check(int row, int col, int n) {
		int std = map[row][col];
		for (int i = row; i < row + n; ++i) {
			for (int j = col; j < col + n; ++j) {
				if (map[i][j] != std)
					return false;
			}
		}
		ans[map[row][col] + 1]++;
		return true;
	}

	private static void dfs(int row, int col, int n) {
		if (check(row, col, n)) return;
		for (int i = row; i < row + n; i += n / 3)
			for (int j = col; j < col + n; j += n / 3)
				dfs(i, j, n / 3);
	}

}
