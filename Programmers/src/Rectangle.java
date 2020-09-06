
public class Rectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static long gcd(int w, int h) {

        if (h == 0) {
            return w;
        } else {
            return gcd(h, (w % h));
        }
    }

    public static long solution(int w, int h) {
        long gcd = gcd(w, h);
        long answer = 1;

        answer = ((long)w*(long)h) - ((((long)w / gcd) + ((long)h / gcd) - 1) * gcd);
        return answer;
    }
    
}
