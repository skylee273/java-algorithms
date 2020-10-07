import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_11728 {

	private static int n,m;
	private static int [] A;
	private static int [] B;
	private static int [] K;
	private static String SPACE = " ";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		A = new int[n];
		B = new int[m];
		K = new int[n+m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) A[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; ++i) B[i] = Integer.parseInt(st.nextToken());
		merge();
		StringBuilder sb = new StringBuilder();
		for(int val : K) sb.append(val).append(SPACE);
		System.out.print(sb);
	}
	private static void merge() {
		int i = 0, j = 0, k = 0;
		while(i < n && j < m) {
			if(A[i] >= B[j]) K[k++] = B[j++];
			else K[k++] = A[i++];
		}
		
		while(i < n) K[k++] = A[i++];
		while(j < m) K[k++] = B[j++];
	}
	
}
