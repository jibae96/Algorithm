import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GroupWord1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0; i<n; i++){
            int [] alphbet = new int[26];
            st=new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            alphbet[temp.charAt(0)-'a']++;
            boolean flag = true;
            for(int j=1; j<temp.length();j++){
                if(temp.charAt(j-1)==temp.charAt(j)) alphbet[temp.charAt(j)-'a']++;
                else if(temp.charAt(j-1)!=temp.charAt(j) && alphbet[temp.charAt(j)-'a']==0) alphbet[temp.charAt(j)-'a']++;
                else if(temp.charAt(j-1)!=temp.charAt(j) && alphbet[temp.charAt(j)-'a']!=0) {
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        System.out.println(count);
    }
}
