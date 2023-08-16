import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int target, cost;

	public Edge(int target, int cost) {
		this.target = target;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

public class Main {
    static int V,E,K;
    static int u,v,w;
    static int [] dist;
    static ArrayList[] list;
        
    public static void main(String[] args) throws Exception  {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        
        dist = new int[V+1];
        for (int i=1; i<=V; i++) {
        	dist[i] = Integer.MAX_VALUE;
        }
        
        list = new ArrayList[V+1];
        for (int i=1; i<=V; i++) {
        	list[i] = new ArrayList<Edge>();
        }
        
        for (int i=1; i<=E; i++) {
        	st = new StringTokenizer(br.readLine());  	
        	u = Integer.parseInt(st.nextToken());
        	v = Integer.parseInt(st.nextToken());
        	w = Integer.parseInt(st.nextToken());
        	list[u].add(new Edge(v,w));
        }
        
        dijkstra(K);
        
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=V; i++) {
        	if (dist[i] == Integer.MAX_VALUE) {
        		sb.append("INF\n");
        	}
        	else {
        		sb.append(dist[i]+"\n");
        	}
        }
        
        System.out.println(sb.toString());
        
        br.close();
    }    

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); 
        dist[start] = 0;
        pq.add(new Edge(start,0));
        
        while(!pq.isEmpty()) {
        	Edge cur = pq.poll();
        	
        	if (cur.cost > dist[ cur.target ]) continue;
        	
        	int len = list[cur.target].size();
        	for (int i = 0; i<len; i++) {
        		Edge next = (Edge) list[cur.target ].get(i);
        		
        		if (dist[next.target] > cur.cost + next.cost ) {
        			dist[next.target] = cur.cost + next.cost;
        			pq.add(new Edge(next.target, dist[next.target]));
        		}
        	}
        }
    }
}