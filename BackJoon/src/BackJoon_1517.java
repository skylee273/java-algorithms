import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_1517 {

	private static int [] arr;
	private static int cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		mergeSort(0, n-1);
		System.out.print(cnt);
		
		
	}

	private static void mergeSort(int start, int end ) {
		if(start >= end) return;
		int middle = (start + end) / 2;
		mergeSort(start, middle);
		mergeSort(middle+1, end);
		merge(start, middle, end);
	}
	private static void merge(int start, int middle, int end) {
		int i, j, k;
		
		i = start;
		j = middle + 1;
		k = i;
		int [] temp = new int[arr.length];
		while(i <= middle && j <= end) {
			if(arr[i] <= arr[j])
				temp[k] = arr[i++];
			else {
				temp[k] = arr[j++];
				cnt += middle + 1 - i;
			}
			k++;
		}
		
		while(j <= end) temp[k++] = arr[j++];
		while(i <= middle) temp[k++] = arr[i++];
		for(i = start; i <= end; ++i) arr[i] = temp[i];	 
	}
}
