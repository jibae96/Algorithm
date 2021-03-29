import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alphbet10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] alphbet = new int [26];
        int a='a';
        int z='z';
        System.out.println(a+" "+z);
        for(int i=0; i<word.length(); i++){
            if(i==0 && alphbet[word.charAt(i)-97]==0)
                alphbet[word.charAt(i)-97]=-1;
            if(alphbet[word.charAt(i)-97]==0)
                alphbet[word.charAt(i)-97]=i;
        }
        for(int i=0; i<alphbet.length; i++){
            if(alphbet[i]==-1) System.out.print("0 ");
            else if(alphbet[i]!=0) System.out.print(alphbet[i]+" ");
            else System.out.print("-1"+" ");
        }
    }
}
