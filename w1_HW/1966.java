import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int test = sc.nextInt();
        int[] out = new int[test]; 
                
        for(int i=0; i<test; i++) {
            LinkedList<int[]> queue = new LinkedList<>();
            
            int count = 0;
            
            int n = sc.nextInt(); 
            int m = sc.nextInt();
            
            for(int j=0; j<n; j++)
                queue.add(new int[] {j, sc.nextInt()});
            
            while(!queue.isEmpty()){
                int[] front = queue.poll();
                boolean isMax = true;
                
                for (int[] q : queue) {
                    if(q[1] > front[1])
                        isMax = false;	
                }
                
                if (isMax) {
                    count++;
                    
                    if (front[0]==m) 
                    	break;
                }else {
                	queue.add(front);
                }
            }
            
            out[i] = count;
        }
        
        for(int i=0; i<test; i++) {
        	System.out.println(out[i]);
        }
        
        sc.close();
    }
}