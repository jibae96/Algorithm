import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGB10026 {
    static char[][] rgb;
    static boolean[][] visited;
    static int n;
    static int count1,count2;
    static int[] goX={-1,0,1,0};
    static int[] goY={0,1,0,-1};
    static void dfs(int x, int y){
        visited[x][y]=true;
        for(int i=0; i<4; i++){
            int cx = x+goX[i];
            int cy = y+goY[i];
            if(cx>=0 && cy>=0 && cx<n && cy<n) {
                if (rgb[cx][cy] == rgb[x][y] && visited[cx][cy] == false) {
                    dfs(cx, cy);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        rgb = new char[n][n];

        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            String temp = br.readLine();
            for(int j=0; j<n; j++){
                rgb[i][j]=temp.charAt(j);
            }
        }
        count1=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]==false){
                    dfs(i,j);
                    count1++;
                }
            }
        }
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(rgb[i][j]=='G')
                    rgb[i][j]='R';
            }
        }
        count2=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]==false){
                    dfs(i,j);
                    count2++;
                }
            }
        }
        System.out.println(count1+" "+count2);
    }
}
