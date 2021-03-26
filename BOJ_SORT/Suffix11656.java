import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Suffix11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String[] array = new String[word.length()];
        for(int i=0; i<array.length; i++) {
            array[i] = word.substring(i, word.length());
            //System.out.println(array[i]);
        }
        Arrays.sort(array);
        for(int i=0; i<array.length; i++)
            System.out.println(array[i]);
    }
}
