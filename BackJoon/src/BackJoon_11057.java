import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_11057 {

	static int NUMS = 10;
	static int DIV = 10007;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		
		long [][] dp = new long[n+1][NUMS];
		for(int i = 0; i < NUMS; ++i) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= n; ++i) {
			for(int j = 0; j < NUMS; ++j ) {
				for(int k = j; k >= 0; --k) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= DIV;
				}
			}
		}
		int ans = 0;
        for(int i=0; i<=9; i++){
            ans += dp[n][i];            
        }
        
		System.out.print(ans);
	}

}
