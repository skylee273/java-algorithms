import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2004 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		// 조합 공식 nCr = n! / ((n-r)! * (r!)
	
		int twoCnt = getCount(n, 2) - getCount(n-r, 2) - getCount(r, 2);
		int fiveCnt = getCount(n, 5) - getCount(n-r, 5) - getCount(r, 5);
		System.out.print(Math.min(twoCnt, fiveCnt));
	}

	private static int getCount(int x, int y) {
		int cnt = 0;
		while(x >= y) {
			cnt += x / y;
			x /= y;
		}
		return cnt;
	}
}
