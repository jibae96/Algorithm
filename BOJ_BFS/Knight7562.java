import java.util.*;

public class Knight7562 {
    int [] goX = {-2,-2,-1,1,2,2,1,-1};
    int [] goY = {-1,1,2,2,1,-1,-2,-2};
    public void solution(int board, int startX, int startY, int endX, int endY){
        if(startX==endX && startY==endY) {
            System.out.println("0");
            return;
        }
        Queue<MyDot> queue = new LinkedList<>();
        int[][] chessBoard = new int[board][board];
        queue.add(new MyDot(startX,startY));
        while(!queue.isEmpty()){
            MyDot temp = queue.poll();
            for(int i=0;i<8;i++){
                int cx = temp.x+goX[i];
                int cy = temp.y+goY[i];
                if(cx>=0 && cx<board && cy>=0 && cy<board){
                    if(chessBoard[cx][cy]==0){
                        chessBoard[cx][cy] = chessBoard[temp.x][temp.y]+1;
                        queue.add(new MyDot(cx,cy));
                    }
                }
            }
        }
        System.out.println(chessBoard[endX][endY]);
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
        Knight7562 knight = new Knight7562();
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0; i<n; i++){
            int board = sc.nextInt();
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int endX = sc.nextInt();
            int endY = sc.nextInt();
            knight.solution(board,startX,startY,endX,endY);
        }
    }
}
