import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Relations2644 {
    static int n;
    static int [][] family;
    static boolean[] visited;
    static int count;
    static boolean flag;
    static void dfs(int who1, int who2, int count){
        visited[who1]=true;
        for(int i=1; i<=n; i++){
            if(family[who1][i]==1 && visited[i]==false){
                if(i==who2) {
                    System.out.println(count+1);
                    flag = true;
                    return;
                }
                dfs(i,who2,count+1);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        family = new int[n+1][n+1];
        visited = new boolean[n+1];
        flag = false;
        st = new StringTokenizer(br.readLine());
        int who1 = Integer.parseInt(st.nextToken());
        int who2 = Integer.parseInt(st.nextToken());
        int testcase = Integer.parseInt(br.readLine());
        for(int i=0; i<testcase; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            family[x][y]=family[y][x]=1;
        }
        count=0;
        dfs(who1,who2,count);
        if(!flag) System.out.println(-1);
    }
}
