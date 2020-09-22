import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BackJoon_10809 {

	static final int SIZE = 26;
	static String SPACE = " ";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] alpabet = br.readLine().toCharArray();

		int[] temp = new int[SIZE];

		Arrays.fill(temp, -1);

		for (int i = 0; i < alpabet.length ; ++i) {
			if(temp[(alpabet[i] - 'a')] == -1)
				temp[(alpabet[i] - 'a')] = i;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < SIZE; ++i) {
			sb.append(temp[i]).append(SPACE);
		}
		System.out.print(sb.toString());
	}

}
