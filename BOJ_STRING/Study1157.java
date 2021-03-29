import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Study1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();
        int[] array = new int[26];
        for(int i=0; i<word.length(); i++){
            array[word.charAt(i)-'A']++;
        }

        int max=-1;
        char result='?';
        for(int i=0; i<26; i++){
            if(array[i]>max){
                max=array[i];
                result=(char)(i+'A');
            }else if(array[i]==max)
                result='?';
        }
        System.out.print(result);
    }
}
