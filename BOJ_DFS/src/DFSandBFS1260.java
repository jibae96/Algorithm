import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSandBFS1260 {
    static int[][] array;
    static boolean [] visited;
    static void DFS(int v, int n){
        visited[v]=true;
        System.out.print(v+" ");
        for(int i=1; i<=n; i++){
            if(array[v][i]==1 && visited[i]==false){
                DFS(i,n);
            }
        }
    }
    static void BFS(int v,int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v]=true;
        System.out.print(v+" ");
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i=1; i<=n;i++){
                if(array[temp][i]==1 && visited[i]==false){
                    queue.add(i);
                    visited[i]=true;
                    System.out.print(i+" ");
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        array = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int tempX = Integer.parseInt(st.nextToken());
            int tempY = Integer.parseInt(st.nextToken());
            array[tempX][tempY] = array[tempY][tempX]=1;
        }
        DFS(v,n);
        System.out.println("");
        visited = new boolean[n+1];
        BFS(v,n);
    }
}
