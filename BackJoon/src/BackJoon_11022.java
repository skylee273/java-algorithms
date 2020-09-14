import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_11022 {

	static String CASE = "Case #";
	static String COLON = ": ";
	static String PLUS = " + ";
	static String EQUL = " = ";
	static String ENTER = "\n";
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 1; i < testCase+1; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int SUM = A+B;
			
			sb.append(CASE + i + COLON + A + PLUS + B + EQUL + SUM  + ENTER);
		}
		System.out.print(sb.toString());
		
	}

}
