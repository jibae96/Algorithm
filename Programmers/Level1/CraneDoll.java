import java.util.*;

class CraneDoll {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        boolean flag = false;

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<moves.length; i++){
            int current = moves[i]-1;
            flag = false;
            for(int j=0; j<board.length; j++){
                if(board[j][current]!=0 && !flag){
                    flag = true;
                    if(!stack.isEmpty() && stack.peek()==board[j][current]) {
                        stack.pop();
                        answer += 2;
                    }
                    else {
                        stack.add(board[j][current]);
                    }
                    board[j][current]=0;
                }
            }
        }

        return answer;
    }
}
