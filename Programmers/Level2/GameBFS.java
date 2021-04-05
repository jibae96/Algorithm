import java.util.*;

// BFS

public class GameBFS {
    public static int row;
    public static int col;
    public static boolean[][] visited;
    public static int [] goX = {-1,0,1,0};
    public static int [] goY = {0,1,0,-1};
    class MyPoint{
        int x;
        int y;
        public MyPoint(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
    }
    public int solution(int[][] maps){
        int answer = 0;
        row = maps.length;
        col = maps[0].length;
        visited = new boolean[row][col];
        BFS(maps, 0, 0);
        if(maps[row-1][col-1]==1) return -1;
        else return maps[row-1][col-1];
    }
    public void BFS(int[][] maps, int x, int y){
        visited[x][y]=true;
        Queue<MyPoint> queue = new LinkedList<>();
        queue.add(new MyPoint(x,y));
        while(!queue.isEmpty()){
            MyPoint current = queue.poll();
            for(int i=0; i<4; i++){
                int tempX = current.getX()+goX[i];
                int tempY = current.getY()+goY[i];
                if(tempX>=0 && tempY>=0 && tempX<row && tempY<col){
                    if(!visited[tempX][tempY] && maps[tempX][tempY]!=0){
                        queue.add(new MyPoint(tempX, tempY));
                        visited[tempX][tempY]=true;
                        maps[tempX][tempY]=maps[current.getX()][current.getY()]+1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        GameBFS game = new GameBFS();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        game.solution(maps);
    }
}
