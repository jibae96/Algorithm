import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SafetyArea2468 {
    static int [][] area;
    static boolean [][] visited;
    static int max=1;
    static int[] goX = {-1,0,1,0};
    static int[] goY = {0,1,0,-1};
    static void findArea(int height){
        int count = 0;
        visited = new boolean[area.length][area.length];
        for(int i=0; i<area.length; i++){
            for(int j=0; j<area.length; j++){
                if(area[i][j]>height && visited[i][j]==false){
                    dfs(i,j,height);
                    count++;
                }
            }
        }
        max = Math.max(max,count);
    }
    static void dfs(int x, int y, int height){
        if(visited[x][y]==true || area[x][y]<=height) return;
        visited[x][y]=true;
        for(int i=0; i<4; i++){
            int cx = x+goX[i];
            int cy = y+goY[i];
            if(cx>=0 && cy>=0 && cx<area.length && cy<area.length)
                dfs(cx,cy,height);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> hs = new HashSet<>();
        area = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int temp = Integer.parseInt(st.nextToken());
                area[i][j] = temp;
                hs.add(temp);
            }
        }
        for(int height : hs){
            if(height<=100) findArea(height);
        }
        System.out.println(max);
    }
}
