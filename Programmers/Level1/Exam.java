import java.util.*;

class Exam {
    public int[] solution(int[] answers) {
        int[] answer;

        int [] first = {1,2,3,4,5};
        int [] second = {2,1,2,3,2,4,2,5};
        int [] third = {3,3,1,1,2,2,4,4,5,5};

        int [] score = new int [3];

        for(int i=0; i<answers.length; i++){
            if(answers[i]==first[i%5]) score[0]++;
            if(answers[i]==second[i%8]) score[1]++;
            if(answers[i]==third[i%10]) score[2]++;
        }

        int max = score[0];

        if(score[1]>score[2]){
            if(score[1]>max) max = score[1];
        }else{
            if(score[2]>max) max = score[2];
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<score.length; i++)
            if(max==score[i]) list.add(i+1);

        answer = new int [list.size()];
        int index = 0;

        for(int temp : list)
            answer[index++] = temp;

        return answer;
    }
}
