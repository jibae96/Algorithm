import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zero10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] array = new int [n];
        int index=0;
        for(int i=0;i<n;i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp==0) array[--index]=0;
            else array[index++]=temp;
        }
        int sum=0;
        for(int i=0; i<n; i++){
            if(array[i]!=0) sum+=array[i];
        }
        System.out.println(sum);
    }
}
