import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int v, e;
	static ArrayList<Integer>[] arr;
	static int visit[];
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		int t = Integer.parseInt(stz.nextToken());

		for(int j = 0; j < t; j++) {
			stz = new StringTokenizer(br.readLine());
			v = Integer.parseInt(stz.nextToken());
			e = Integer.parseInt(stz.nextToken());
			arr = new ArrayList[v+1];
			visit = new int[v+1];

			for(int i = 0; i <= v; i++)
				arr[i] = new ArrayList<Integer>();

			for(int i = 0; i < e; i++) {
				stz = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(stz.nextToken());
				int p2 = Integer.parseInt(stz.nextToken());

				arr[p1].add(p2);
				arr[p2].add(p1);
			}
			isGraph();
		}
		System.out.println(sb);
	}

	public static void isGraph() {
		Queue<Integer> q = new LinkedList<Integer>();

		for(int i = 1; i <= v; i++) {
			if(visit[i] == 0) {
				q.add(i);
				visit[i] = 1;
			}

			while(!q.isEmpty()) {
				int now = q.poll();

				for(int j = 0; j < arr[now].size(); j++) {
					if(visit[arr[now].get(j)] == 0) {
						q.add(arr[now].get(j));
					}
					
					if(visit[arr[now].get(j)] == visit[now]) {
						sb.append("NO").append("\n");
						return;
					}

					if(visit[now] == 1 && visit[arr[now].get(j)] == 0)
						visit[arr[now].get(j)] = 2;
					else if(visit[now] == 2 && visit[arr[now].get(j)] == 0)
						visit[arr[now].get(j)] = 1;
				}
			}
		}
		sb.append("YES").append("\n");
	}
}