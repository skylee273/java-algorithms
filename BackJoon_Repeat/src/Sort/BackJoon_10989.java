package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BackJoon_10989 {

	private static int MAX = 10001;
	private static Number[] nums = new Number[MAX];
	private static String NEW_LINE ="\n";
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i < MAX; ++i) nums[i] = new Number(false, 0);
		for(int i = 0; i < n; ++i) {
			int idx = Integer.parseInt(br.readLine());
			nums[idx].visit = true;
			nums[idx].cnt += 1;
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < MAX; ++i) {
			if(nums[i].visit) {
				while(nums[i].cnt-- > 0) {
					sb.append(i).append(NEW_LINE);
				}
			}
		}
		
		System.out.print(sb);
	}
	private static class Number{
		boolean visit;
		int cnt;
		private Number(boolean visit, int cnt) {
			this.visit = visit;
			this.cnt = cnt;
		}
	}
	
	
}
