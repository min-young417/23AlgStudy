import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int dx[] = {0, 0, 1, -1};
    static final int dy[] = {1, -1, 0, 0};
    static int lab[][];
    static int n,m;
    static int maxSafeZone = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lab = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);

        System.out.println(maxSafeZone);
    }

    static void DFS(int wallCnt) {
        if(wallCnt == 3) {
            BFS();
            return;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(lab[i][j] == 0) {
                    lab[i][j] = 1;
                    DFS(wallCnt+1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    static void BFS() {
        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(lab[i][j] == 2) {
                    q.add(new Node(i,j));
                }
            }
        }

        int copyMap[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyMap[i] = lab[i].clone();
        }

        while(!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            
            for(int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(0<=nx && nx<n && 0<=ny && ny<m) {
                    if(copyMap[nx][ny] == 0) {
                        q.add(new Node(nx,ny));
                        copyMap[nx][ny] = 2;
                    }
                }
            }
        }
        safezone(copyMap);
    }

    private static void safezone(int[][] copyMap) {
        int safe = 0;
        for(int i=0; i<n ; i++) {
            for(int j=0; j<m; j++) {
                if(copyMap[i][j] == 0) {
                    safe++;
                }
            }
        }
        if (maxSafeZone < safe) {
            maxSafeZone = safe;
        }
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}