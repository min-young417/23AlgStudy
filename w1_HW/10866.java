import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] out = new int[N]; 
        int out_num = 0;
        
        LinkedList<Integer> deque = new LinkedList<>();

        for(int i=0; i<N; i++){
            String oper = sc.next();

            switch(oper){
                case "push_front":
                    deque.offerFirst(sc.nextInt());
                    break;
                case "push_back":
                    deque.offerLast(sc.nextInt());
                    break;
                case "pop_front":
                	if(deque.isEmpty()) {
                    	out[out_num] = -1;
                    	out_num++;
                    }else {
                    	out[out_num] = deque.pollFirst();
                    	out_num++;
                    }
                    break;
                case "pop_back":
                    if(deque.isEmpty()) {
                    	out[out_num] = -1;
                    	out_num++;
                    }else {
                    	out[out_num] = deque.pollLast();
                    	out_num++;
                    }
                    break;
                case "size":
                	out[out_num] = deque.size();
                	out_num++;
                    break;
                case "empty":
                    if(deque.isEmpty()) {
                    	out[out_num] = 1;
                    	out_num++;
                    }else {
                    	out[out_num] = 0;
                    	out_num++;
                    }
                    break;
                case "front":
                    if(deque.isEmpty()) {
                    	out[out_num] = -1;
                    	out_num++;
                    }else {
                    	out[out_num] = deque.getFirst();
                    	out_num++;
                    }
                    break;
                case "back":
                    if(deque.isEmpty()) {
                    	out[out_num] = -1;
                    	out_num++;
                    }else {
                    	out[out_num] = deque.getLast();
                    	out_num++;
                    }
                    break;
            }
        }

        for(int i=0; i<out_num; i++) {
        	System.out.println(out[i]);
        }
        
        sc.close();
    }
}