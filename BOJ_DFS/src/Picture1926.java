import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Picture1926 {
    static int n;
    static int m;
    static int[][] board;
    static boolean[][] visited;
    static int[] goX = {-1,0,1,0};
    static int[] goY = {0,1,0,-1};
    static int max=0;
    static int temp;
    static void dfs(int x, int y){
        visited[x][y]=true;
        for(int i=0; i<4; i++){
            int cx = x+goX[i];
            int cy = y+goY[i];
            if(cx>=0 && cy>=0 && cx<n && cy<m){
                if(board[cx][cy]==1 && visited[cx][cy]==false) {
                    dfs(cx, cy);
                    temp++;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 6
        m = Integer.parseInt(st.nextToken()); // 5
        board = new int[n][m];
        visited = new boolean[n][m];
        int count=0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                if(Integer.parseInt(st.nextToken())==1)
                    board[i][j]=1;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]==false && board[i][j]==1) {
                    temp=1;
                    dfs(i, j);
                    count++;
                    max = Math.max(max, temp);
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
}
