import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Connecting11724 {
    static int [][] array;
    static boolean [] visited;
    static int count = 0;
    static void dfs(int start){
        visited[start]=true;
        for(int i=1; i<array.length; i++){
            if(array[start][i]==1 && visited[i]==false){
                dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        array = new int [n+1][n+1];
        visited = new boolean[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            array[x][y]=array[y][x]=1;
        }
        for(int i=1; i<=n; i++){
            if(visited[i]==false){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
}
