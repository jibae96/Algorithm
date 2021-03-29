import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sum11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String temp = br.readLine();
        int sum=0;
        for(int i=0; i<n; i++){
            sum += Integer.parseInt(temp.substring(i,i+1));
        }
        System.out.println(sum);
    }
}
