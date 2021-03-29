import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Print11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        for(int i=0;i<temp.length(); i+=10){
            if(i+10<temp.length())
                System.out.println(temp.substring(i,i+10));
            else System.out.println(temp.substring(i,temp.length()));
        }
    }
}
