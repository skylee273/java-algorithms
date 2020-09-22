import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackJoon_10820 {

	static String SPACE = " ";
	static String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			int[] count = new int[4];
			for (char word : line.toCharArray()) {
				if (word == 32) count[3]++;
				else if (word >= 48 && word <= 57)count[2]++;
				else if (word >= 65 && word <= 90) count[1]++;
				else count[0]++;
			}
			sb.append(count[0]).append(SPACE).append(count[1]).append(SPACE)
			.append(count[2]).append(SPACE).append(count[3]).append(NEW_LINE);
		}
		System.out.print(sb.toString());
	}

}
