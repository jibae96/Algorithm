class Square{
    public int solution(int [][]board){
        int answer = 0;
        int max = 0;

        for(int i=1; i<board.length; i++){
            for(int j=1; j<board[i].length; j++){
                if(board[i][j]!=0){
                    int min = Math.min(board[i-1][j],Math.min(board[i-1][j-1],board[i][j-1]));
                    board[i][j] = min+1;
                    max = Math.max(max,board[i][j]);
                }

            }
        }
        if(max==0 && board[0][0]==1) answer = 1;
        else answer = max*max;

        return answer;
    }
}
