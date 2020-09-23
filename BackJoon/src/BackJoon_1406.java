import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BackJoon_1406 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();

		Stack<String> left = new Stack<String>();
		Stack<String> right = new Stack<String>();

		for (int i = 0; i < word.length(); ++i)
			left.push(word.substring(i, i + 1));

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			switch (st.nextToken()) {
			case "P": {
				left.push(st.nextToken());
				break;
			}
			case "L": {
				if (!left.isEmpty())
					right.push(left.pop());
				break;
			}
			case "D": {
				if (!right.isEmpty())
					left.push(right.pop());
				break;
			}
			case "B": {
				if (!left.isEmpty())
					left.pop();
				break;
			}

			}
		}
		StringBuilder sb = new StringBuilder();
		while (!left.isEmpty())
			right.push(left.pop());
		while (!right.isEmpty())
			sb.append(right.pop());

		System.out.print(sb.toString());

	}

}
