import java.util.*;

class NotFinished {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<participant.length; i++){
            if(i<completion.length){
                if(!participant[i].equals(completion[i]))
                    return participant[i];
            }
        }

        answer = participant[participant.length-1];

        return answer;
    }
}
