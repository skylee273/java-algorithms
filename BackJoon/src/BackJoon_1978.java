import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_1978 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int ans = 0;
		while (n-- > 0) {
			int count = 0;
			int prime = Integer.parseInt(st.nextToken());
			if(prime == 1) continue;
			for(int i = 1; i <= prime; ++i) {
				if(prime % i == 0)
					count++;
			}
			ans += count > 2 ? 0 : 1;
		}

		System.out.print(ans);
	}
	

}
