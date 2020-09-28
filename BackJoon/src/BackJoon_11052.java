import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_11052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] dp = new int[n+1];
		int [] price = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <=n; ++i)
			price[i] = Integer.parseInt(st.nextToken());
		
		dp[0] = 0;
		dp[1] = price[1];
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= i; ++j )
			dp[i] = Math.max(dp[i], price[j] + dp[i-j]);
		}
		System.out.print(dp[n]);
	}

}
