import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Calc2822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] array = new int[8];
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0; i<8; i++){
            st=new StringTokenizer(br.readLine());
            array[i]=Integer.parseInt(st.nextToken());
            hm.put(array[i],i+1);
        }
        Arrays.sort(array);
        int total=0;
        StringBuilder sb = new StringBuilder();
        int[] result = new int [5];

        for(int i=3; i<8; i++) {
            total += array[i];
            result[i-3]=hm.get(array[i]);
        }
        Arrays.sort(result);
        for(int i=0; i<5; i++)
            sb.append(result[i]).append(' ');
        System.out.println(total);
        System.out.println(sb);
    }
}
