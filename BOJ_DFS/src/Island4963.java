import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Island4963 {
    static int w;
    static int h;
    static int[][] land;
    static boolean[][] visited;
    static int count;
    static int[] goX = {-1,-1,-1,0,1,1,1,0};
    static int[] goY = {-1,0,1,1,1,0,-1,-1};
    static void dfs(int x, int y){
        visited[x][y]=true;
        for(int i=0; i<8; i++){
            int cx = x+goX[i];
            int cy = y+goY[i];
            if(cx>=0 && cy>=0 && cx<h && cy<w){
                if(land[cx][cy]==1 && visited[cx][cy]==false)
                    dfs(cx,cy);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        w = Integer.parseInt(st.nextToken()); //5
        h = Integer.parseInt(st.nextToken()); //4
        while(w!=0 && h!=0){
            land = new int[h][w];
            visited = new boolean[h][w];
            count=0;
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    land[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(land[i][j]==1 && visited[i][j]==false){
                        dfs(i,j);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }
}
