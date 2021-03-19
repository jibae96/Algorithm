import java.util.*;

public class Maze2178 {
    int n;
    int m;
    int[][] array;
    boolean[][] visited;
    int[] goX = {-1,0,1,0};
    int[] goY = {0,1,0,-1};

    public class MyPoint{
        int x;
        int y;
        MyPoint(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
    }

    public void solution(int N, int M, int[][] arr){
        n = N;
        m = M;
        array = arr;
        visited = new boolean[n][m];
        BFS(0,0);
        visited[0][0]=true;
    }
    public int BFS(int a, int b){
        Queue<MyPoint> queue = new LinkedList<>();
        queue.add(new MyPoint(a,b));

        while(!queue.isEmpty()){
            MyPoint myPoint = queue.poll();
            for(int i=0; i<4; i++){
                int cx = myPoint.getX()+goX[i];
                int cy = myPoint.getY()+goY[i];
                if(cx>=0 && cx<n && cy>=0 && cy<m){
                    if(!visited[cx][cy] && array[cx][cy]!=0){
                        queue.add(new MyPoint(cx,cy));
                        array[cx][cy]=array[myPoint.getX()][myPoint.getY()]+1;
                        visited[cx][cy]=true;
                    }
                }
            }
        }

        System.out.println(array[n-1][m-1]+"!");
        return array[n-1][m-1];
    }
    public static void main(String[] args) throws Exception{
        Maze maze = new Maze();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] myArray = new int[N][M];
        scanner.nextLine();
        for(int i=0; i<N; i++){
            String str = scanner.nextLine();
            for(int j=0; j<M; j++){
                myArray[i][j]=Integer.parseInt(str.substring(j,j+1));
            }
        }
        maze.solution(N,M,myArray);
    }
}
