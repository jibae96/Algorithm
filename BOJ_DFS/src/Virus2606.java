import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Virus2606 {
    static int[][] array;
    static int count;
    static boolean [] visited;
    static void dfs(int start){
        visited[start]=true;
        for(int i=1; i<array.length;i++){
            if(array[start][i]==1 && visited[i]==false){
                visited[i]=true;
                count++;
                dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        count=0;
        array = new int[n+1][n+1];
        visited = new boolean[n+1];
        int relation = Integer.parseInt(br.readLine());
        for(int i=0; i<relation; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            array[x][y]=array[y][x]=1;
        }
        dfs(1);
        System.out.println(count);
    }
}
