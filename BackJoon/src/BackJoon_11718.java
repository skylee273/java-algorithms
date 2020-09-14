import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_11718 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		while(true) {
			String input = br.readLine();
			if(input == null) break;
			sb.append(input + "\n");
		}
		
		System.out.print(sb);
		
	}

}
