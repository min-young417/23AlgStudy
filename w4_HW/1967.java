import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static class node{
        int n;
        int w;

        node(int num, int weight){
            this.n = num;
            this.w = weight;
        }
    }

    static int n, longestdist, furthestNode;
    static ArrayList<node>[] adj;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n+1];
        longestdist = 0;
        furthestNode = 0;
        isVisited = new boolean[n+1];

        for(int i = 0 ; i < n+1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < n-1; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            int w = Integer.parseInt(stringTokenizer.nextToken());

            adj[p].add(new node(c, w));
            adj[c].add(new node(p, w));
        }

        isVisited[1] = true;
        DFS(1, 0);

        isVisited = new boolean[n+1];
        longestdist = 0;
        isVisited[furthestNode] = true;
        DFS(furthestNode, 0);

        System.out.println(longestdist);

    }

    private static void DFS(int nodeNum, int distSum) {
        if(longestdist < distSum){
        	longestdist = distSum;
            furthestNode = nodeNum;
        }
        
        for(node next : adj[nodeNum]){
            if(isVisited[next.n]) continue;

            isVisited[next.n] = true;
            DFS(next.n, distSum + next.w);
        }
    }
}