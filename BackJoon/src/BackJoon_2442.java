import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2442 {

	static String STAR = "*";
	static String NEW_LINE = "\n";
	static String SPACE = " ";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n =  Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n+i; ++j) {
				if(j < n - i -1 )
					sb.append(SPACE);
				else
					sb.append(STAR);
			}
			sb.append(NEW_LINE);
		}
		System.out.print(sb);
	}

}
