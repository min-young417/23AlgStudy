import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static class Node {
	    char data;
	    Node left;
	    Node right;
	    
	    Node(char data) {
	        this.data = data;
	    }
	}
	
    static StringBuffer sb;
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(in.readLine());
        Node[] arr = new Node[N];
        
        for (int i = 0; i < N; i++)
            arr[i] = new Node((char)('A' + i));
        
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            arr[str.charAt(0)-'A'].left = str.charAt(2) == '.' ? null : arr[str.charAt(2) - 'A'];
            arr[str.charAt(0)-'A'].right = str.charAt(4) == '.' ? null : arr[str.charAt(4) - 'A'];
        }
        
        sb = new StringBuffer();
        preOrder(arr[0]);
        sb.append("\n");
        inOrder(arr[0]);
        sb.append("\n");
        postOrder(arr[0]);
        sb.append("\n");
        System.out.println(sb);
    }

    
    static void preOrder(Node node) {
    	sb.append(node.data);
        if (node.left != null)  preOrder(node.left);
        if (node.right != null) preOrder(node.right);
    }
    
    static void inOrder(Node node) {
        if (node.left != null)  inOrder(node.left);
        sb.append(node.data);
        if (node.right != null) inOrder(node.right);
    }
    
    static void postOrder(Node node) {
        if (node.left != null)  postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        sb.append(node.data);
    }
}