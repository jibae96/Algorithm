import java.util.*;

class FourBlock {
    char [][] map;
    int M;
    int N;
    Queue<Dot> queue;
    class Dot{
        int x;
        int y;
        public Dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
  
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new char[m][n];
        M = m;
        N = n;
        queue = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }

        int count = 1;

        while(count!=0){
            count = 0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j]!='*'){
                        makeSquare(i,j,map[i][j]);
                    }
                }
            }

            while(!queue.isEmpty()){
                Dot current = queue.poll();
                if(map[current.x][current.y]!='*'){
                    map[current.x][current.y]='*';
                    answer++;
                    count++;
                }else continue;
            }

            getDown();
        }

        return answer;
    }

    public void makeSquare(int x, int y, char ch){
        int [] goX = {0,1,1};
        int [] goY = {1,0,1};
        Queue<Dot> temp = new LinkedList<>();

        for(int i=0; i<3; i++){
            int tempX = x+goX[i];
            int tempY = y+goY[i];
            if(tempX>=0 && tempY>=0 && tempX<M && tempY<N){
                if(map[tempX][tempY]==ch){
                    temp.add(new Dot(tempX,tempY));
                }
            }
        }

        if(temp.size()==3){
            queue.add(new Dot(x,y));
            for(int i=0; i<3; i++){
                queue.add(temp.poll());
            }
        }
    }

    public void getDown(){
        for(int h=0; h<M; h++){
            for(int i=0; i<M-1; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]!='*' && map[i+1][j]=='*'){
                        map[i+1][j] = map[i][j];
                        map[i][j] = '*';
                    }
                }
            }
        }
    }
}
