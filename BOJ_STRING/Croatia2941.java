import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Croatia2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String[] alphbet = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        for(int i=0; i<alphbet.length; i++){
            word = word.replaceAll(alphbet[i],"*");
        }
        System.out.println(word.length());
    }
}
