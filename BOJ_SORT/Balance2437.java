import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Balance2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int [] weights = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            weights[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(weights);
        if(weights[0]!=1) {
            System.out.println("1");
            return;
        }
        int sum=weights[0];
        for(int i=1;i<n;i++){
            if(weights[i]>sum+1){
                System.out.println(sum+1);
                return;
            }
            sum+=weights[i];
        }
        System.out.println(sum+1);
    }
}
