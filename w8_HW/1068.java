import java.util.Scanner;

public class Main {
    static int n, delete;
    static int[] parent;
    static int count;
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        
        parent = new int[n];
        int root = 0;
        for(int i = 0; i < n; i++) {
            parent[i] = sc.nextInt();        
            if(parent[i] == -1) root = i;
        }
        
        delete = sc.nextInt();
        
        parent[delete] = -2; 
        for(int i = 0; i < n; i++) {
            if(parent[i] == delete) {
                deleteNode(i);
            }
        }
            
        count = 0;
        visited = new boolean[n];
        countLeaf(root);
            
        System.out.println(count);
    }
    
    public static void deleteNode(int d) {
        parent[d] = -2; 
        for(int i = 0; i < n; i++) {
            if(parent[i] == d) {
                deleteNode(i);
            }
        }
    }
    
    public static void countLeaf(int s) {
        boolean isLeaf = true;
        visited[s] = true;
        if(parent[s] != -2) {
            for(int i = 0; i < n; i++) {
                if(parent[i] == s && visited[i] == false) {
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) count++;
        }
    }
}