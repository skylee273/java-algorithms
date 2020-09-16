import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_11055 {

	static int n;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		dp = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <=n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; ++i) {
			dp[i] = arr[i];
			for(int j = 1; j < i; ++j) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
		}
		
		int ans = 0;
		for(int i = 1; i <= n; ++i) {
			ans = Math.max(dp[i], ans);
		}
		System.out.print(ans);
	}

}
