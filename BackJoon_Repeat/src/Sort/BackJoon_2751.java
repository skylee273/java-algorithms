package Sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BackJoon_2751 {

	private static int POSITIVE = 1000001;
	private static int INF = 2000002;
	private static boolean [] num;
	private static String NEW_LINE = "\n";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		num = new boolean[INF];
		while (n-- > 0) {
			int idx = Integer.parseInt(br.readLine());
			idx = idx < 0 ? (-1) * idx : idx + POSITIVE;
			num[idx] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		// negative 
		for(int i = POSITIVE-1; i > 0; --i)
			if(num[i])
				sb.append(-i).append(NEW_LINE);
		//positive
		for(int i = POSITIVE; i < INF; ++i)
			if(num[i])
				sb.append(i-POSITIVE).append(NEW_LINE);
		System.out.print(sb);
	}
}
