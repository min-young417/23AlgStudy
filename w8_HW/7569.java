import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato{
    int z, x, y;

    public tomato(int z, int x, int y){
        this.z = z;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int dx[] = {-1, 0, 1, 0, 0, 0};
    static int dy[] = {0, 1, 0, -1, 0, 0};
    static int dz[] = {0, 0, 0, 0, 1, -1};
    
    static int M, N, H;
    static int box[][][];
    static Queue<tomato> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H+1][N+1][M+1];

        for(int i = 1; i <= H; i++){
            for(int j = 1; j <= N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= M; k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1) q.add(new tomato(i, j, k));
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!q.isEmpty()){
            tomato t = q.poll();

            int z = t.z;
            int x = t.x;
            int y = t.y;

            for(int i = 0 ; i < 6; i++){
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(checkPoint(nz, nx, ny)){
                    q.add(new tomato(nz, nx, ny));
                    box[nz][nx][ny] = box[z][x][y] + 1;
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for(int i = 1; i <= H; i++){
            for(int j = 1; j <= N; j++){
                for(int k = 1; k <= M; k++){
                    if(box[i][j][k] == 0) return -1;
                    result = Math.max(result, box[i][j][k]);
                }
            }
        }
        if(result == 1) return 0;
        else return (result - 1);
    }

    private static boolean checkPoint(int z, int x, int y){
        if(z < 1 || z > H || x < 1 || x > N || y < 1 || y > M) return false;
        if(box[z][x][y] == 0) return true;
        else return false;
    }
}