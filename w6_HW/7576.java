import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class tomato{
	int x;
	int y;
	
	tomato(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main{
	static int M, N;
	static int[] dx = {-1, -1, 0, 0};
	static int[] dy = {0, 0, -1, -1};
	static int[][] box;
	static Queue<tomato> tq;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		box = new int[N][M];
		tq = new LinkedList<tomato>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				box[i][j] = sc.nextInt();
				if(box[i][j] == 1)
					tq.add(new tomato(i,  j));
			}
		}
		System.out.println(BFS());
	}
	
	public static int BFS() {
		while(!tq.isEmpty()) {
			tomato t = tq.remove();
			int x = t.x, y = t.y; 
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if(box[nx][ny] == 0) {
						tq.add(new tomato(nx, ny));
						box[nx][ny] = box[x][y] + 1;
					}
				}
			}
		}
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 0)
					return -1;
				result = Math.max(result, box[i][j]);
			}
		}
		if(result == 1) return 0;
		else return result-1;
	}
}