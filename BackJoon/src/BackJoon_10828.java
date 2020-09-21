import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_10828 {

	static int index = -1;
	static String NEW_LINE = "\n";
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("push")) {
				int val = Integer.parseInt(st.nextToken());
				push(val);
			} else if (command.equals("top")) {
				sb.append(top()).append(NEW_LINE);
			} else if (command.equals("size")) {
				sb.append(size()).append(NEW_LINE);
			} else if (command.equals("pop")) {
				sb.append(pop()).append(NEW_LINE);
			} else {
				sb.append(isEmpty()).append(NEW_LINE);
			}
		}
		System.out.print(sb.toString());
	}

	private static int pop() {
		if (index == -1)
			return -1;
		return arr[index--];
	}

	private static void push(int val) {
		arr[++index] = val;
	}

	private static int size() {
		return index + 1;
	}

	private static int top() {
		if (index == -1)
			return -1;
		else
			return arr[index];
	}

	private static int isEmpty() {
		if (index == -1)
			return 1;
		else
			return 0;
	}

}
