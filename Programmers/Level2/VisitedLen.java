import java.util.*;

// HashSet으로 비교 불가..

public class VisitedLen {
    public static int[] goX = {0,1,0,-1}; // U R D L
    public static int[] goY = {1,0,-1,0};
    public static boolean[][][][] visited = new boolean[11][11][11][11];
    public static int x,y; // 현재 위치
    public static int nextX, nextY; // 이동할 위치
    public int solution(String dirs) {
        int answer = 0;
        x = 5;
        y = 5;
        nextX = 5;
        nextY = 5;

        for(int i=0; i<dirs.length(); i++){
            x = nextX;
            y = nextY;
            if(dirs.charAt(i)=='U'){
                nextX = x + goX[0];
                nextY = y + goY[0];
            }else if(dirs.charAt(i)=='R'){
                nextX = x + goX[1];
                nextY = y + goY[1];
            }else if(dirs.charAt(i)=='D'){
                nextX = x + goX[2];
                nextY = y + goY[2];
            }else{
                nextX = x + goX[3];
                nextY = y + goY[3];
            }

            if(nextX<0 || nextY<0 || nextX>10 || nextY>10){
                nextX = x;
                nextY = y;
                continue;
            }
            if(!visited[x][y][nextX][nextY]){
                visited[x][y][nextX][nextY]=true;
                visited[nextX][nextY][x][y]=true;
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        VisitedLen v = new VisitedLen();
        String dirs = "ULURRDLLU";
        v.solution(dirs);
    }
}
