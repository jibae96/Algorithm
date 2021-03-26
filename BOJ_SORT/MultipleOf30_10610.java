import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MultipleOf30_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String num = st.nextToken();
        int[] array = new int [10];
        int total=0;
        for(int i=0; i<num.length(); i++){
            int temp = Integer.parseInt(num.substring(i,i+1));
            array[temp]+=1;
            total+=temp;
        }
        if(!num.contains("0") || total%3!=0){
            System.out.println("-1");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--){
            while(array[i]>0){
                sb.append(i);
                array[i]--;
            }
        }
        System.out.println(sb);
    }
}
