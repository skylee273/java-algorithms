import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class BackJoon_11652 {

	static String NEW_LINE = "\n";
	static String SPACE = " ";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long[] arr = new long[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);

		int maxCnt = 0;
		long tmp = arr[0];
		int cnt = 0;
		for (int i = 1; i < n; ++i) {
			cnt = arr[i] == arr[i - 1] ? cnt + 1 : 0;
			if (maxCnt < cnt) {
				maxCnt = cnt;
				tmp = arr[i - 1];
			}
		}

		System.out.print(tmp);
	}

}
