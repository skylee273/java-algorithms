import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_10991 {

	static String SPACE = " ";
	static String NEW_LINE = "\n";
	static String STAR = "*";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; ++i) {
			for(int j = i; j <= n-1; ++j) {
				sb.append(SPACE);
			}
			for(int j = 1; j <= 2*i-1; ++j ) {
				if(j % 2 != 0)
					sb.append(STAR);
				else
					sb.append(SPACE);
			}
			sb.append(NEW_LINE);
		}
		System.out.print(sb);
	}

}
