import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int[][] d;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][2];
		d = new int[N][N];
		
		for(int i=0; i<N; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

        System.out.print(Dp(0,N-1));
	}
	
	static int Dp(int s,int e)
	{
		int min = Integer.MAX_VALUE;

		if(s == e) return 0;
		if(d[s][e]!=0) return d[s][e];

		for(int i=s; i<e; i++)
		{
			int value = arr[s][0] * arr[i+1][0] * arr[e][1] +Dp(s,i)+ Dp(i+1,e);
			min = Math.min(min,value);
		}
		
		return min;
	}
}