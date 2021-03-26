import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Combine11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int [] array = new int[n+m];
        int index=0;

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            array[index++]=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++)
            array[index++]=Integer.parseInt(st.nextToken());
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<array.length; i++)
            sb.append(array[i]).append(" ");
        System.out.print(sb);
    }
}
