import java.util.Scanner;

public class Main {
	private static int c(int n, int k) {
		if(n == k || k ==0) 
			return 1;
		return c(n-1, k-1) + c(n-1, k);
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(c(n-1, k-1));
	}
}