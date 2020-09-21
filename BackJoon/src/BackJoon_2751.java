import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BackJoon_2751 {

	static int n;
	//static ArrayList<Integer> array;
	static String NEW_LINE = "\n";
	static int POSITIVE = 1_000_001;
	static int INF = 2_000_002;
	static boolean[] num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new boolean[INF];
		//array = new ArrayList<Integer>();
		while(n-- > 0) {
			int idx = Integer.parseInt(br.readLine());
			idx = idx < 0 ? (idx) * (-1) : idx + POSITIVE;
			num[idx] = true;
			//array.add(num);
		}
		StringBuilder sb = new StringBuilder();

		
		for(int i = POSITIVE-1; i > 0; --i) {
			if(num[i])
				sb.append(-i).append(NEW_LINE);
		}
		
		for(int i = POSITIVE;  i < INF; ++i) {
			if(num[i])
				sb.append(i-POSITIVE).append(NEW_LINE);
		}

		//Collections.sort(array);
		
		
		/*
		for(int num : array) {
			sb.append(num + NEW_LINE);
		}
		*/
		System.out.print(sb.toString());
	}

	
}
