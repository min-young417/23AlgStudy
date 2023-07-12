import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		
        int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N+1];
		int[][] dp = new int[N+1][N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i <= N; i++) {
			int temp = Integer.parseInt(st.nextToken());
            nums[i]=temp;
			for(int j=1; j<=i; j++) {
				if(i==j)dp[j][i] = 1;
				else if(i-j==1) dp[j][i] = (nums[i]==nums[j])?1:0;
				else dp[j][i] = (nums[i]==nums[j] && dp[j+1][i-1]==1)?1:0;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
			
			if(dp[S][E] == 1) {
				sb.append(dp[S][E]).append("\n");
			}else {
				sb.append(dp[S][E]).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}