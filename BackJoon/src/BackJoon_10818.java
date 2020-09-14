import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BackJoon_10818 {

	static String SPACE = " ";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testCase = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), SPACE);
		
		int min = 1000001;
		int max = -1000001;
		for(int i = 0; i < testCase; ++i) {
			int value = Integer.parseInt(st.nextToken());
			if(value < min)
				min = value;
			if(value > max) {
				max = value;
			}
		}
		
		System.out.print(min + SPACE + max);
	}

}
