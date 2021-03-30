import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[][] array = new int[s1.length()+1][s2.length()+1];

        for(int i=1; i<=s1.length(); i++){
            char temp1 = s1.charAt(i-1);
            for(int j=1; j<=s2.length(); j++){
                char temp2 = s2.charAt(j-1);
                if(temp1==temp2) array[i][j]=array[i-1][j-1]+1;
                else array[i][j]=Math.max(array[i][j-1],array[i-1][j]);
            }
        }
        System.out.println(array[s1.length()][s2.length()]);
    }
}
