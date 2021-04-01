import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS2_9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1= br.readLine();
        String s2= br.readLine();
        int[][] array = new int[s1.length()+1][s2.length()+1];
        for(int i=1; i<=s1.length(); i++){
            char temp1 = s1.charAt(i-1);
            for(int j=1; j<=s2.length(); j++){
                char temp2 = s2.charAt(j-1);
                if(temp1==temp2) array[i][j]=array[i-1][j-1]+1;
                else array[i][j]=Math.max(array[i-1][j],array[i][j-1]);
            }
        }
        char[] temp1 = s1.toCharArray();
        char[] temp2 = s2.toCharArray();
        int a = temp1.length;
        int b = temp2.length;
        StringBuilder sb = new StringBuilder();
        while(!(a==0 || b==0)){
            if(temp1[a-1]==temp2[b-1]){
                sb.append(temp1[a-1]);
                a--;
                b--;
            }else if(array[a][b]==array[a-1][b])
                a--;
            else if(array[a][b]==array[a][b-1])
                b--;
        }
        System.out.println(array[s1.length()][s2.length()]);
        if(array[s1.length()][s2.length()]!=0) System.out.println(sb.reverse());
    }
}
