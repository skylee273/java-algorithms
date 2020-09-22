import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BackJoon_10866 {

	static int rear = 0;
	static int front = 0;
	static String NEW_LINE = "\n";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Deque<Integer> deque = new LinkedList<Integer>();

		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push_back": {
				deque.addLast(Integer.parseInt(st.nextToken()));
				break;
			}
			case "push_front": {
				deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
			}
			case "front": {
				sb.append(deque.isEmpty()? -1 : deque.peek()).append(NEW_LINE);
				break;
			}
			case "back": {
				sb.append(deque.isEmpty()? -1 : deque.peekLast()).append(NEW_LINE);
				break;
			}
			case "size": {
				sb.append(deque.size()).append(NEW_LINE);
				break;
			}
			case "empty": {
				sb.append(deque.isEmpty()? 1: 0).append(NEW_LINE);
				break;
			}
			case "pop_front": {
				sb.append(deque.isEmpty()? -1 : deque.pop()).append(NEW_LINE);
				break;
			}
			case "pop_back": {
				sb.append(deque.isEmpty()? -1 : deque.removeLast()).append(NEW_LINE);
				break;
			}

			}
		}
		System.out.print(sb.toString());

	}

	
}
