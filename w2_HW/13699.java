import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long[]t = new long[36];
		
		t[0] = 1;
        t[1] = 1;
		for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                t[i] += t[j] * t[i - 1 - j];
            }
        }
		
		System.out.println(t[n]);
		
		sc.close();
	}
}