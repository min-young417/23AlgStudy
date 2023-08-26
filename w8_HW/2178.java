import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class location{
    int x, y;
    
    public location(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      char[][] miro = new char[N][M];  
      int[][] dist = new int[N][M];  
      
      int[] dx = {1, 0 , -1, 0};       
      int[] dy = {0, 1, 0, -1}; 
      
      Queue<location> q = new LinkedList<>();
      
      for(int i=0; i<N; i++){
          String line = br.readLine();
          for(int j=0; j<M; j++){
              miro[i][j] = line.charAt(j);
              dist[i][j] = -1;
          }
      }
      
      q.offer(new location(0,0));
      dist[0][0] = 0; 
      
      while(!q.isEmpty()){
    	  location l = q.poll();
          
          for(int i=0; i<4; i++){
            int nX = l.x + dx[i];
            int nY = l.y + dy[i];
            
            if(nX < 0 || nX >= N || nY < 0 || nY >= M) continue;
            if(miro[nX][nY] == '0' || dist[nX][nY] != -1) continue;
            
            q.offer(new location(nX, nY));
            dist[nX][nY] = dist[l.x][l.y] + 1;
          }
      }
      System.out.print(dist[N-1][M-1] + 1);
    }
}