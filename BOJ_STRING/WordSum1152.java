import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WordSum1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine().trim();
        if(temp.isEmpty()){
            System.out.println("0");
            return;
        }
        String[] array = temp.split(" ");
        System.out.println(array.length);
    }
}
