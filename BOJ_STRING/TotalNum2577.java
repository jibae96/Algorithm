import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TotalNum2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        long total = a*b*c;
        String thing = String.valueOf(total);
        int [] count = new int [10];
        for(int i=0; i<thing.length(); i++){
            count[Integer.parseInt(thing.substring(i,i+1))]++;
        }
        for(int i=0; i<count.length; i++)
            System.out.println(count[i]);
    }
}
