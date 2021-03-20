import java.util.*;

public class Cabbage1012 {
    boolean[][] visited;
    int[] goX = {-1,0,1,0};
    int[] goY = {0,1,0,-1};
    public void solution(int[][] array){
        int count=0;
        visited = new boolean[array.length][array[0].length];
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++){
                if(!visited[i][j] && array[i][j]==1){
                    bfs(array,i,j);
                    visited[i][j]=true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public void bfs(int[][] array,int a, int b){
        Queue<MyDot> queue = new LinkedList<>();
        queue.add(new MyDot(a,b));
        while(!queue.isEmpty()){
            MyDot dot = queue.poll();
            for(int i=0; i<4; i++){
                int cx=dot.x+goX[i];
                int cy=dot.y+goY[i];
                if(cx>=0 && cx<array.length && cy>=0 && cy<array[0].length){
                    if(array[cx][cy]==1 && !visited[cx][cy]){
                        queue.add(new MyDot(cx,cy));
                        visited[cx][cy]=true;
                    }
                }
            }
        }
    }
    class MyDot{
        int x;
        int y;
        public MyDot(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cabbage1012 cabbage1012 = new Cabbage1012();
        int count=sc.nextInt();
        for(int i=0; i<count; i++){
            int N = sc.nextInt();//5
            int M = sc.nextInt();//3
            int relations = sc.nextInt();
            int[][] map = new int[N][M];
            for(int j=0; j<relations; j++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                map[a][b]=1;
            }
            cabbage1012.solution(map);
        }
    }
}
