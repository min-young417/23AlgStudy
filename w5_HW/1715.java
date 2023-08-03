import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}

		int count = 0;
		int first = 0;
		int second = 0;
		
		while(q.size() != 1) {
			first = q.remove();
			second = q.remove();
			
			count += first + second;
			q.add(first+second);
		}
		
		System.out.println(count);
	}
}