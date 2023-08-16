import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int start;
	int end;
	int result;
	
	Node(int start, int end, int result){
		this.start = start;
		this.end = end;
		this.result = result;
	}
	
	@Override
	public int compareTo(Node o) {
		return result - o.result;
	}
}

public class Main{
	static ArrayList<Node> nodeList;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		nodeList = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); 
			int end = Integer.parseInt(st.nextToken()); 
			int result = Integer.parseInt(st.nextToken());
			
			nodeList.add(new Node(start, end, result));
		}
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		Collections.sort(nodeList);
		
		int answer = 0;
		for(Node list : nodeList) {
			Node node = list;
			
			if(find(node.start) != find(node.end)) {
				answer += node.result;
				union(node.start, node.end);
			}
		}
		
		System.out.println(answer+"\n");
	}
	
	public static int find(int answer) {
		if(parent[answer] == answer) {
			return answer;
		}else {
			return parent[answer] = find(parent[answer]);
		}
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			parent[y] = x;
		}
	}
}