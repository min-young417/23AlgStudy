import java.util.Scanner;
import java.util.Stack;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		Stack<Character> stack = new Stack<>();
		boolean tag = false;
		
		for(int i=0; i < S.length(); i++) {
			if(S.charAt(i) == '<') {
				tag = true;
				
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				
				System.out.print(S.charAt(i));
			}else if(S.charAt(i)=='>'){
				tag = false;
				
				System.out.print(S.charAt(i));
			}else if(tag) {
				System.out.print(S.charAt(i));
			}else if(!tag) {
				if(S.charAt(i)==' ') {
					while(!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
					System.out.print(S.charAt(i));
				}else {
					stack.push(S.charAt(i));
				}
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		
		sc.close();
	}
}