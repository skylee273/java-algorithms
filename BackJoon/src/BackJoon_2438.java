import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2438 {

	static String NEW_LINE = "\n";
	static String STAR = "*";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; ++i) {
			for(int j = 0; j < i; ++j) {
				sb.append(STAR);
			}
			sb.append(NEW_LINE);
		}
		System.out.print(sb);
		
	}

}
