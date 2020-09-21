import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2225 {

	static int DIV =  1000000000;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long [][]dp = new long[k+1][n+1];
		
		for(int i = 0; i <= n; ++i) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= k; ++i) {
			for(int j = 0; j <= n; ++j) {
				for(int l = 0; l <= j; ++l) {
					dp[i][j] += dp[i-1][j-l];
				}
				dp[i][j] = (dp[i][j] % DIV);
			}
		}
		
		System.out.print(dp[k][n]);
	}

}
