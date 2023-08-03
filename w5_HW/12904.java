import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int res;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder s = new StringBuilder(br.readLine());
		StringBuilder t = new StringBuilder(br.readLine());
		
		int flag=0;
		while(t.length()>s.length()) {
			if(t.charAt(t.length()-1) == 'A') {
				t.delete(t.length()-1, t.length());
			}else {
				t.delete(t.length()-1, t.length());
				t.reverse();
			}
			
			
			if(t.length() == s.length()) {
				if(t.toString().equals(s.toString())) 
					flag =1;
				break;
			}
		}
		System.out.println(flag);
	}
}