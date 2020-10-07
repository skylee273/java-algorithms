import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_1992 {

	private static int [][] map;
	private static StringBuilder sb = new StringBuilder();
	private static String OPEN = "(";
	private static String CLOSE = ")";
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for(int i = 0; i < n; ++i) {
			String str = br.readLine();
			for(int j = 0; j < n; ++j) {
				map[i][j] = (str.charAt(j) - '0');
			}
		}
		dfs(0, 0, n);
		System.out.print(sb);
	}
	
	private static boolean check(int row, int col, int n) {
		int std = map[row][col];
		for(int i = row; i < row + n; ++i)
			for(int j = col; j < col + n; ++j) 
				if (map[i][j] != std) return false;
		sb.append(std);
		return true;
	}
	private static void dfs(int row, int col, int n) {
		if(check(row, col, n)) return ;
		sb.append(OPEN);
		for(int i = row; i < row + n; i += n / 2)
			for(int j = col; j < col + n; j += n / 2)
				dfs(i, j, n / 2);
		sb.append(CLOSE);
	}

}
