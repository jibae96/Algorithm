import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NotRepeat10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(!list.contains(temp)) list.add(temp);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<list.size(); i++)
            sb.append(list.get(i)).append(' ');
        System.out.print(sb);
    }
}
