import java.util.*;

class Kth {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];

        for(int i=0; i<commands.length; i++){
            int start = commands[i][0];
            int end = commands[i][1];

            int [] temp = new int [end-start+1];
            int index = 0;

            for(int j=start-1; j<=end-1; j++){
                temp[index++] = array[j];
            }

            Arrays.sort(temp);

            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
