import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_11576 {

	static String SPACE = " ";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");
		
		int ans = 0;
		for (int i = 0; i < n; ++i) {
			int num = Integer.parseInt(st.nextToken());
			ans = ans * A + num;
		}
		getConvert(ans, B);
	}

	private static void getConvert(int demical, int b) {
		if(demical == 0)
			return;
		getConvert(demical/b, b);
		System.out.print(demical%b + " ");
	}

}
