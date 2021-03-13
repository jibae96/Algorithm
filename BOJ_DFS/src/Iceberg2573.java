import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Iceberg2573 {
    static int n;
    static int m;
    static int [][] area;
    static int [][] temparea;
    static boolean [][] visited;
    static int[] goX = {-1,0,1,0};
    static int[] goY = {0,1,0,-1};
    static int icearea;
    public static void dfs(int x,int y){
        visited[x][y]=true;
        for(int i=0; i<4; i++){
            int cy = y+goY[i];
            int cx = x+goX[i];
            if(cx>=0 && cy>=0 && cx<n && cy<m){
                if(visited[cx][cy]==false && area[cx][cy]>0)
                    dfs(cx,cy);
            }
        }
    }
    public static int getLinked(){
        int count=0;
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(area[i][j]>0 && visited[i][j]==false){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static int nextYear(int x, int y){
        int count=0;
        if(area[x][y]>0){
            for(int i=0; i<4; i++){
                int cx = x+goX[i];
                int cy = y+goY[i];
                if(cx>=0 && cy>=0 && cx<n && cy<m){
                    if(area[cx][cy]==0) count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        area = new int[n][m];
        temparea = new int[n][m];
        icearea = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                if(area[i][j]>0) icearea++;
            }
        }

        int year=0;
        int linked=0;
        while((linked=getLinked())<2){
            if(linked==0){
                year=0;
                break;
            }
            year++;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(area[i][j]>0){
                        temparea[i][j]=Math.max(area[i][j]-nextYear(i,j),0);
                    }
                }
            }
            for(int i=0; i<n; i++)
                for(int j=0; j<m; j++)
                    area[i][j] = temparea[i][j];

        }
        System.out.println(year);
    }
}
