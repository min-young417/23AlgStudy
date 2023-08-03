import java.util.Scanner;

public class Main{
    static int[][] city;
    static boolean[] visited;
    static int n;
    static int answer;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        city = new int[n+1][n+1];
        visited = new boolean[n+1];
        answer = Integer.MAX_VALUE;
        
        for(int i=1;i<=n;++i)
            for(int j=1;j<=n;++j)
                city[i][j] = sc.nextInt();

        for(int i =1;i<=n;++i){
            visited[i] = true;
            DFS(1,1,0,0);
        }
        
        System.out.println(answer);
    }
    
    public static void DFS(int start, int now, int sum, int count){
        if(count == n-1){
            if(city[now][start] != 0){
                sum += city[now][start];
                answer = Math.min(answer,sum);
            }
            return;
        }

        for(int i =1;i<=n;++i){
            if(!visited[i] && city[now][i]!=0){
                visited[i] = true;
                DFS(start,i,(sum+city[now][i]),count+1);
                visited[i] = false;
            }
        }
    }
}