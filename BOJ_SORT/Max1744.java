import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Max1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] array = new Integer[n];
        for(int i=0; i<n; i++){
            array[i]= Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        int left=0;
        int right=n-1;
        long sum=0;
        for(;left<right; left+=2){
            if(array[left]<1 && array[left+1]<1)
                sum += (array[left]*array[left+1]);
            else break;
        }
        for(;right>0; right-=2){
            if(array[right]>1 && array[right-1]>1)
                sum += (array[right]*array[right-1]);
            else break;
        }
        for(;right>=left;right--)
            sum+=array[right];
        System.out.println(sum);

    }
}
