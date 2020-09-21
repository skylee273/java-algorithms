import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackJoon_11004 {

	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(0, n - 1);
		System.out.print(arr[k-1]);
	}

	private static void quickSort(int low, int high) {
		if(low >= high)
			return;
		int left = low;
		int right = high;
		int pivot = arr[(low + high) / 2];

		while (left <= right) {
			while (arr[left] < pivot)
				left++;
			while (arr[right] > pivot)
				right--;
			if (left <= right) {
				swap(left, right);
				left++;
				right--;
			}
		}
		quickSort(low, right);
		quickSort(left, high);
	}

	private static void swap(int l, int r) {
		int temp;
		temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}
}
