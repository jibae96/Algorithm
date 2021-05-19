import java.util.*;

public class OpenChatting {
    public String[] solution(String[] record) {
        String[] answer;
        HashMap<String,String> hm = new HashMap<>();
        int count = 0;

        for(int i=0; i<record.length; i++){
            String[] temp = record[i].split(" ");
            switch(temp[0]){
                case "Leave" :
                    count++;
                    break;
                case "Enter" :
                    count++;
                    hm.put(temp[1],temp[2]);
                    break;
                case "Change" :
                    hm.put(temp[1],temp[2]);
                    break;
            }
        }

        answer = new String [count];
        int index = 0;

        for(int i=0; i<record.length; i++){
            String[] tmp = record[i].split(" ");
            if(tmp[0].equals("Enter")){
                answer[index]=hm.get(tmp[1])+"님이 들어왔습니다.";
                index++;
            }else if(tmp[0].equals("Leave")){
                answer[index]=hm.get(tmp[1])+"님이 나갔습니다.";
                index++;
            }
        }

        return answer;
    }
}
