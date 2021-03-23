import java.util.*;

public class Island4963 {
    int[] goX={-1,0,1,0,-1,1,1,-1};
    int[] goY={0,1,0,-1,1,1,-1,-1};
    public void solution(int a, int b, int[][] arr){
        int count=0;
        boolean[][] visited = new boolean[b][a];
        for(int i=0; i<b; i++){
            for(int j=0; j<a; j++){
                if(!visited[i][j] && arr[i][j]==1){
                    bfs(i,j,arr,visited);
                    visited[i][j]=true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    class MyDot{
        int x;
        int y;
        public MyDot(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public void bfs(int i, int j, int[][] array, boolean[][] visited){
        Queue<MyDot> queue = new LinkedList<>();
        queue.add(new MyDot(i,j));
        while(!queue.isEmpty()){
            MyDot dot = queue.poll();
            for(int u=0; u<8; u++){
                int cx = dot.x+goX[u];
                int cy = dot.y+goY[u];
                if(cx>=0 && cx<array.length && cy>=0 && cy<array[0].length){
                    if(!visited[cx][cy] && array[cx][cy]==1){
                        queue.add(new MyDot(cx,cy));
                        visited[cx][cy]=true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Island4963 island = new Island4963();
        int[][] map;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); //5
        int b = sc.nextInt(); //4
        while(a!=0 && b!=0){
            map = new int[b][a];
            for(int i=0; i<b; i++){
                for(int j=0; j<a; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            island.solution(a,b,map);
            a = sc.nextInt();
            b = sc.nextInt();
        }
    }
}
