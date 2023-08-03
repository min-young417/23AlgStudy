import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();

        int count = 0;
      
        char prev = S.charAt(0);
        
        for(int i=1; i < S.length(); i++) {
        	if(S.charAt(i) == prev) {
        		continue;
        	}
        	
        	count++;
        	
        	for(int j=i; j < S.length(); j++) {
        		if(S.charAt(j) == prev) {
            		break;
            	}
        		i++;
        	}
        }

        System.out.println(count);
    }
}