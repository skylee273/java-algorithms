import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_1373 {

	static final int DIV = 3;
	static char ZERO = '0';

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] binary = br.readLine().toCharArray();
		int digit = binary.length;

		StringBuilder sb = new StringBuilder();
		if (digit % DIV == 1)
			sb.append(binary[0] - ZERO);
		else if (digit % DIV == 2)
			sb.append((binary[0] - ZERO) * 2 + binary[1] - ZERO);
		for (int i = digit % DIV; i < digit; i += 3)
			sb.append((binary[i] - ZERO) * 4 + (binary[i + 1] - ZERO) * 2 + binary[i + 2] - ZERO);

		System.out.print(sb.toString());
	}

}
