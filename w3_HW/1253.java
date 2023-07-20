import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] a = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i <N; i++) {
			a[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(a);
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			long present = a[i];
			int s = 0;
			int e = N-1;
			
			while(s < e) {
				if(a[s]+a[e] == present) {
					if(s != i && e != i) {
						cnt++;
						break;
					}else if(s == i) {
						s++;
					}else if(e == i) {
						e--;
					}
				}else if(a[s] + a[e] < present) {
					s++;
				}else {
					e--;
				}
			}
		}
		System.out.println(cnt);
	}
}