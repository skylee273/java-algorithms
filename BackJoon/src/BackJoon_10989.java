import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BackJoon_10989 {

	static String NEW_LINE = "\n";
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [] array = new int[n];
		for(int i = 0; i < n; ++i) {
			array[i] = Integer.parseInt(br.readLine());
		}		
		br.close();
		Arrays.sort(array);
		
		StringBuilder sb = new StringBuilder();
		for(int v : array) {
			sb.append(v).append(NEW_LINE);
		}
		System.out.print(sb.toString());
	}

}
