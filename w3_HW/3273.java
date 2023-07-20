import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine());
		
		Arrays.sort(a);
		
		int s = 0;
		int e = n-1;
		int cnt = 0;
		
		while(s < e) {
			if(a[s]+a[e] <= x) {
				if(a[s]+a[e] == x) cnt++;
				s++;
			}else {
				e--;
			}
		}
		System.out.println(cnt);
	}
}