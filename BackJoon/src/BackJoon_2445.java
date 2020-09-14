import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2445 {

	static String STAR = "*";
	static String NEW_LINE = "\n";
	static String SPACE = " ";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n =  Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < (2 * n - 1); ++i) {
			if(i <= (2*n-1) / 2) {
				for(int j = 0; j < n; ++j) {
					if(j <= i)
						sb.append(STAR);
					else
						sb.append(SPACE);
				}
				for(int j = 0; j < n; ++j) {
					if(j < n - i - 1)
						sb.append(SPACE);
					else	
						sb.append(STAR);
				}
			}else {
				for(int j = 0; j < n; ++j) {
					if(j < (n - (i%n) - 1))
						sb.append(STAR);
					else
						sb.append(SPACE);
				}
				for(int j = 0; j < n; ++j) {
					if(j < (i%n) + 1 )
						sb.append(SPACE);
					else	
						sb.append(STAR);
				}
			}
			
			sb.append(NEW_LINE);
		}
		System.out.print(sb);
	}

}
