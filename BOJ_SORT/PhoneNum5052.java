import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PhoneNum5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int m = Integer.parseInt(br.readLine());
            String [] book = new String[m];
            for(int j=0; j<m; j++){
                book[j]=br.readLine();
            }
            Arrays.sort(book);
            boolean flag = false;
            for(int j=0; j<m-1; j++){
                if(book[j+1].startsWith(book[j])){
                    flag = true;
                    break;
                }
            }
            if(flag) sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.println(sb);
    }
}
