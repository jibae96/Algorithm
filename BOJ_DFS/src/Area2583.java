import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Area2583 {
    static int[][] area;
    static boolean[][] visited;
    static int m;
    static int n;
    static ArrayList<Integer> list;
    static int count;
    static int [] goX={-1,0,1,0};
    static int [] goY={0,1,0,-1};
    static void dfs(int x, int y){
        visited[x][y]=true;
        for(int i=0; i<4; i++){
            int cx = x+goX[i];
            int cy = y+goY[i];
            if(cx>=0 && cy>=0 && cx<n && cy<m){
                if(area[cx][cy]==0 && visited[cx][cy]==false){
                    dfs(cx,cy);
                    count++;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        m = Integer.parseInt(st.nextToken()); //5
        n = Integer.parseInt(st.nextToken()); //7
        area = new int[n][m];
        visited = new boolean[n][m];
        int testcase = Integer.parseInt(st.nextToken());
        for(int i=0; i<testcase; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()); //4
            int y1 = Integer.parseInt(st.nextToken()); //0
            int x2 = Integer.parseInt(st.nextToken()); //6
            int y2 = Integer.parseInt(st.nextToken()); //2
            for(int j=y1; j<y2; j++){
                for(int k=x1; k<x2; k++){
                    area[k][j]=1;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(area[i][j]==0 && visited[i][j]==false){
                    count=1;
                    dfs(i,j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++)
            System.out.print(list.get(i)+" ");
    }
}
