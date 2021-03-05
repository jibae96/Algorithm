import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Apartment2667 {
    static int n;
    static int [][] array;
    static int [][] visited;
    static int count;
    static int [] goX = {-1,0,1,0};
    static int [] goY = {0,1,0,-1};
    static void dfs(int x, int y){
        visited[x][y]=1;
        for(int i=0; i<4; i++){
            int tempX = x+goX[i];
            int tempY = y+goY[i];
            if(tempX>0 && tempY>0 && tempX<=n && tempY<=n){
                if(array[tempX][tempY]==1 && visited[tempX][tempY]==0){
                    dfs(tempX,tempY);
                    count++;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        array = new int[n+1][n+1];
        visited = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            String temp = br.readLine();
            for(int j=1; j<=n; j++)
                array[i][j]=temp.charAt(j-1)-'0';
        }
        /*for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }*/
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(array[i][j]==1 && visited[i][j]==0){
                    count=1;
                    dfs(i,j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i));
    }
}
