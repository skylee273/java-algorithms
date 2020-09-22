import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_10845 {

	static int front = 0;
	static int rear = 0;
	static int[] arr;
	static String NEW_LINE = "\n";
	private static final int INF = 10_001;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[INF];
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
			case "push": {
				int val = Integer.parseInt(st.nextToken());
				push(val);
				break;
			}
			case "front": {
				sb.append(getFront()).append(NEW_LINE);
				break;
			}
			case "back": {
				sb.append(getBack()).append(NEW_LINE);
				break;
			}
			case "empty": {
				sb.append(isEmpty()).append(NEW_LINE);
				break;
			}
			case "size": {
				sb.append(size()).append(NEW_LINE);
				break;
			}
			case "pop": {
				sb.append(pop()).append(NEW_LINE);
				break;
			}

			}

		}
		System.out.print(sb.toString());
	}

	private static void push(int val) {
		arr[rear++] = val;
	}

	private static int isEmpty() {
		return front == rear ? 1 : 0;
	}

	private static int getFront() {
		return isEmpty() == 1 ? -1 : arr[front];
	}

	private static int getBack() {
		return isEmpty() == 1 ? -1 : arr[rear - 1];
	}

	private static int size() {
		return rear - front;
	}

	private static int pop() {
		return isEmpty() == 1 ? -1 : arr[front++];
	}

}
