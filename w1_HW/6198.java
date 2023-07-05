import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] building = new int[n];
		for(int i=0; i<n; i++) {
			building[i] = sc.nextInt();
		}
		
		long total = 0;
		Stack<Integer> s = new Stack<>();
		for(int i=0; i<n; i++) {
			while(!s.isEmpty() && s.peek() <= building[i]) {
				s.pop();
			}
			
			s.push(building[i]);
			total += s.size()-1;
		}
		
		System.out.println(total);
		
		sc.close();
	}
}