import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_1699 {

	static int N;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		for(int i = 1; i <= N; ++i) {
			dp[i] = i;
		}
		
		for(int i = 1; i <= N; ++i) {
			for(int j = 2; j*j <= i; ++j) {
				dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
			}
		}
		
		System.out.print(dp[N]);
		
		
	}

}
