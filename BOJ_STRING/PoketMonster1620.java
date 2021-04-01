import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PoketMonster1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String,String> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=n; i++){
            String temp = br.readLine();
            hm.put(temp,String.valueOf(i));
            hm.put(String.valueOf(i),temp);
        }
        for(int i=0; i<m; i++){
            sb.append(hm.get(br.readLine())).append('\n');
        }
        System.out.print(sb);
    }
}
