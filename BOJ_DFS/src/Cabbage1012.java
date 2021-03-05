import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cabbage1012 {
    static int [][] array;
    static int [][] visited;
    static int count;
    static int m;
    static int n;
    static int [] goX = {-1,0,1,0};
    static int [] goY = {0,1,0,-1};
    static void dfs(int x, int y){
        visited[x][y]=1;
        for(int i=0; i<4; i++){
            int cx = x+goX[i];
            int cy = y+goY[i];
            if(cx>=0 && cy>=0 && cx<n && cy<m){
                if(array[cx][cy]==1 && visited[cx][cy]==0){
                    dfs(cx,cy);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<testcase; i++){
            count=0;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            array = new int[n][m];
            visited = new int[n][m];
            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                int cy = Integer.parseInt(st.nextToken());
                int cx = Integer.parseInt(st.nextToken());
                array[cx][cy]=1;
            }
            for(int j=0; j<n; j++){
                for(int h=0; h<m; h++){
                    if(array[j][h]==1 && visited[j][h]==0){
                        dfs(j,h);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }
}
