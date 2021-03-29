import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Parentheses9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            int count=0;
            for(int j=0; j<temp.length(); j++){
                if(temp.substring(j,j+1).equals("(")) count++;
                else count--;
                if(count<0){
                    break;
                }
            }
            if(count==0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
