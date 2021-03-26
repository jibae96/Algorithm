import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Card11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long [] array = new long[n];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            long temp = Long.parseLong(st.nextToken());
            array[i]=temp;
        }
        Arrays.sort(array);
        int max=1;
        int count=1;
        long result = array[0];
        for(int i=0; i<n-1; i++){
            if(array[i]==array[i+1]){
                count++;
            }else count=1;
            if(count>max){
                max = count;
                result = array[i];
            }
        }
        System.out.println(result);
    }
}
