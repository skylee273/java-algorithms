import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2156 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [] arr = new int[n+1];
		
		for(int i = 1; i <= n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		System.out.print(maxGrape2(n, arr));
		
	}
	public static int maxGrape(int n, int[] arr) {
		int [][] dp = new int[n+1][2];
		if(n == 0)
			return 0;
		if(n == 1)
			return arr[1];
		
		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = arr[1];
		
		for(int i = 2; i <= n; ++i) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1] = (arr[i] + Math.max(dp[i-2][0] + arr[i-1], dp[i-1][0]));
		}
		
		
		return (Math.max(dp[n][0], dp[n][1]));
	}
	public static int maxGrape2(int n, int[] arr) {
		int [] dp = new int[n+1];
		dp[1] = arr[1];
		if(n == 1) return dp[1];
		dp[2] = arr[1] + arr[2];
		if(n == 2) return dp[2];
		
		for(int i = 3; i <=n; ++i) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i] + arr[i-1]));
		}
		return dp[n];
	}
}
