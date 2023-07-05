import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        LinkedList<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

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
                    	sb.append(-1).append('\n');
                    }else {
                    	sb.append(deque.pollFirst()).append('\n');
                    }
                    break;
                case "pop_back":
                    if(deque.isEmpty()) {
                    	sb.append(-1).append('\n');
                    }else {
                    	sb.append(deque.pollLast()).append('\n');
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append('\n');
                    break;
                case "empty":
                    if(deque.isEmpty()) {
                    	sb.append(1).append('\n');
                    }else {
                    	sb.append(0).append('\n');
                    }
                    break;
                case "front":
                    if(deque.isEmpty()) {
                    	sb.append(-1).append('\n');
                    }else {
                    	sb.append(deque.peekFirst()).append('\n');
                    }
                    break;
                case "back":
                    if(deque.isEmpty()) {
                    	sb.append(-1).append('\n');
                    }else {
                    	sb.append(deque.peekLast()).append('\n');
                    }
                    break;
            }
        }

        System.out.println(sb);
        
        sc.close();
    }
}