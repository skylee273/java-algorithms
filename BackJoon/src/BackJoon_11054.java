import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackJoon_11054 {

	static int n;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		dp  = new int[n+1][2];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= n; ++i){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <=n; ++i) {
			dp[i][0] = 1;
			for(int j = 1; j < i; ++j) {
				if(arr[i] > arr[j]) {
					dp[i][0] = Math.max(dp[i][0],dp[j][0] + 1);
				}
			}
		}
		for(int i = n; i >= 1; --i) {
			dp[i][1] = 1;
			for(int j = n; j > i; --j) {
				if(arr[i] > arr[j]) {
					dp[i][1] = Math.max(dp[i][1],dp[j][1] + 1);
				}
			}
		}
		
		int max = 0;
		for(int i = 1; i <= n; ++i) {
			max = Math.max(dp[i][0] + dp[i][1], max);
		}
		System.out.print(max-1);
		
	}

}
