import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_11021 {

	private static String caseStr = "Case #";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testCase = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < testCase; ++i) {
			st =  new StringTokenizer(br.readLine());
			
			sb.append(caseStr + (i+1) + ": " 
			+ (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n" );
		}
		System.out.println(sb.toString());
	}

}
