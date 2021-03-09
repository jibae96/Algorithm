import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Alphabet1987 {
    static int n;
    static int m;
    static char[][] alphabet;
    static boolean[][] visited;
    static HashSet<Character> hs;
    static int[] goX={-1,0,1,0};
    static int[] goY={0,1,0,-1};
    static int max=1;
    static void dfs(int x, int y, int count){
        if(hs.contains(alphabet[x][y])){
            max = Math.max(max,count);
            return;
        }
        hs.add(alphabet[x][y]);
        visited[x][y]=true;
        for(int i=0; i<4; i++){
            int cx = x+goX[i];
            int cy = y+goY[i];
            if(cx>=0 && cy>=0 && cx<n && cy<m){
                if(!hs.contains(alphabet[cx][cy]) && visited[cx][cy]==false) {
                    dfs(cx, cy,count+1);
                }
            }
        }
        hs.remove(alphabet[x][y]);
        visited[x][y]=false;
        max = Math.max(max,count);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        alphabet = new char[n][m];
        visited = new boolean[n][m];
        hs = new HashSet<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for(int j=0; j<m; j++){
                char ch = temp.charAt(j);
                alphabet[i][j]=ch;
            }
        }
        dfs(0,0,1);
        System.out.println(max);
    }
}
