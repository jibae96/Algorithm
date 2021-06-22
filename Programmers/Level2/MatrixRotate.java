class MatrixRotate {
    int min;
    int [][] array;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        array = new int [rows+1][columns+1];
        int count = 1;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                array[i][j] = count++;
            }
        }
        if(queries.length==1){
            answer = new int [1];
            answer[0] = array[queries[0][0]-1][queries[0][1]-1];
            return answer;
        }

        answer = new int [queries.length];

        for(int i=0; i<queries.length; i++){
            answer[i] = rotate(queries[i]);
        }

        return answer;
    }

    public int rotate(int[] query){
        int goX = query[3]-query[1];
        int goY = query[2]-query[0];

        int nowX = query[0]-1;
        int nowY = query[1]-1;
        int now = array[nowX][nowY];

        min = now;

        for(int i=0; i<goY; i++){
            nowY++;
            now = move(nowX,nowY,now);
        }

        for(int i=0; i<goX; i++){
            nowX++;
            now = move(nowX,nowY,now);
        }

        for(int i=0; i<goY; i++){
            nowY--;
            now = move(nowX,nowY,now);
        }

        for(int i=0; i<goX; i++){
            nowX--;
            now = move(nowX,nowY,now);
        }
        return min;
    }

    public int move(int x, int y, int prev){
        int temp = array[x][y];
        min = Math.min(min,temp);
        array[x][y] = prev;

        return temp;
    }

    public static void main(String[] args) {
        int rows = 6;
        int cols = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        MatrixRotate mr = new MatrixRotate();
        mr.solution(rows,cols,queries);
    }
}
