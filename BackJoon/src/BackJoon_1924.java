import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BackJoon_1924 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int sum =0;
		for(int i = 1; i < x; ++i) {
			sum += monthToday(i);
		}
		int day = (sum + y) % 7;
		System.out.print(calculatorDay(day));
		
	}
	public static int monthToday(int month){
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 ||
				month == 12 )
			return 31;
		else if(month == 4 || month == 6 || month == 9 || month == 11)
			return 30;
		else 
			return 28;
	}
	public static String calculatorDay(int day) {
		
		switch (day) {
		case 0: {
			return "SUN";
		}
		case 1: {
			return "MON";
		}
		case 2: {
			return "TUE";
		}
		case 3: {
			return "WED";
		}
		case 4: {
			return "THU";
		}
		case 5: {
			return "FRI";
		}
		case 6: {
			return "SAT";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + day);
		}
		
	}
	
}


