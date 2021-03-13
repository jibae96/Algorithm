import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AvoidFood1743 {
    static int n;
    static int m;
    static int[][] board;
    static boolean[][] visited;
    static int max=0;
    static int [] goX={-1,0,1,0};
    static int [] goY={0,1,0,-1};
    static int count;
    static void dfs(int x, int y){
        visited[x][y]=true;
        count++;
        for(int i=0; i<4; i++){
            int cx = x + goX[i];
            int cy = y + goY[i];
            if(cx>0 && cy>0 && cx<=n && cy<=m){
                if(board[cx][cy]==1 && visited[cx][cy]==false){
                    dfs(cx,cy);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int [n+1][m+1];
        visited = new boolean[n+1][m+1];
        int testcase = Integer.parseInt(st.nextToken());
        for(int i=0; i<testcase; i++){
            st = new StringTokenizer(br.readLine());
            int tempx = Integer.parseInt(st.nextToken());
            int tempy = Integer.parseInt(st.nextToken());
            board[tempx][tempy]=1;
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(board[i][j]==1 && visited[i][j]==false){
                    count=0;
                    dfs(i,j);
                    max = Math.max(count, max);
                }
            }
        }
        System.out.print(max);
    }
}
