import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.zip.InflaterInputStream;

public class BackJoon_10951 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = "";
		while((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input);
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int sum = A+B;
			System.out.println(sum);
		}
		
		
	}

}
