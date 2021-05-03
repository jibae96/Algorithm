import java.util.*;

class Raceway {
    static boolean [][] visited;
    static int [] goX = {-1,0,1,0};
    static int [] goY = {0,1,0,-1};
    static int answer;
    class MyPoint{
        int x;
        int y;
        int direction;
        int cost;
        public MyPoint(int x, int y, int direction, int cost){
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }
    public int bfs(int[][] board, int x, int y, int direction, int cost){
        Queue<MyPoint> queue = new LinkedList<>();
        queue.add(new MyPoint(x,y,direction,cost));
        boolean flag = false;

        while(!queue.isEmpty()){
            MyPoint current = queue.poll();

            for(int i=0; i<4; i++){
                int tempX = current.x+goX[i];
                int tempY = current.y+goY[i];
                int tempD = i;

                if(tempX>=0 && tempX<board.length && tempY>=0 && tempY<board.length && board[tempX][tempY]!=1){
                    //System.out.println(current.x+","+current.y+","+current.direction);
                    if(current.direction==-1){
                        //System.out.println("first");
                        flag = true;
                    }
                    if(current.direction == tempD)
                        flag = true;

                    int new_cost;
                    if(flag) new_cost = 100;
                    else new_cost = 600;

                    if(board[tempX][tempY]==0){
                        board[tempX][tempY] = current.cost + new_cost;
                        queue.add(new MyPoint(tempX,tempY,tempD,current.cost+new_cost));
                    }else{
                        if(board[tempX][tempY] >= current.cost + new_cost){
                            board[tempX][tempY] = current.cost + new_cost;
                            queue.add(new MyPoint(tempX, tempY, tempD, current.cost+new_cost));
                        }
                    }
                    flag = false;
                    visited[tempX][tempY]=true;
                }
            }
        }

        return board[board.length-1][board.length-1];
    }
    public int solution(int[][] board) {
        visited = new boolean[board.length][board.length];
        answer = Integer.MAX_VALUE;

        return bfs(board,0,0,-1,0);
    }

    public static void main(String[] args) {
        Raceway raceway = new Raceway();
        int [][] board = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        int [][] board1 = {{0,0,0},{0,0,0},{0,0,0}};
        int [][] board3 = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
        //System.out.println(board.length);
        System.out.println(raceway.solution(board3));
    }
}
