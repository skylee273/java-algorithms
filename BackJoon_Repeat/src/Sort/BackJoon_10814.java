package Sort;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BackJoon_10814 {

	private static String NEW_LINE = "\n";
	private static String SPACE = " ";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Person[] persons = new Person[n];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			persons[i] = new Person(i, Integer.parseInt(st.nextToken()), st.nextToken());
		}
		Arrays.sort(persons, Person.comparator);

		StringBuilder sb = new StringBuilder();
		for (Person p : persons) {
			sb.append(p.age).append(SPACE).append(p.name).append(NEW_LINE);
		}
		System.out.print(sb);
	}

	private static class Person {
		int age;
		int idx;
		String name;

		private Person(int idx, int age, String name) {
			this.idx = idx;
			this.age = age;
			this.name = name;
		}

		private static Comparator<Person> comparator = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				if (o1.age < o2.age)
					return -1;
				if (o1.age == o2.age) {
					if (o1.idx < o2.idx)
						return -1;
				}
				return 1;
			}
		};
	}

}
