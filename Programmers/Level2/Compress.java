import java.util.*;

class Compress {
    public int[] solution(String msg) {
        int[] answer;
        char ch = 'A';
        HashMap<String,Integer> hm = new HashMap<>();
        int count = 27;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<26; i++){
            hm.put(ch+"",i+1);
            ch++;
        }

        for(int i=0; i<msg.length(); i++){
            boolean flag = true;
            int index = 2;
            while(flag){
                if(i+index>msg.length()){
                    sb.append(msg.substring(i,i+1));
                    //System.out.println(msg.substring(i,i+1)+"!");
                    break;
                }
                if(hm.get(msg.substring(i,i+index))==null){
                    hm.put(msg.substring(i,i+index),count++);
                    sb.append(msg.substring(i,i+index-1)+" ");
                    flag = false;
                    i = i+index-2;
                }else index++;
            }
        }

        //System.out.println(sb);
        String [] temp = sb.toString().split(" ");
        answer = new int [temp.length];

        for(int i=0; i<temp.length; i++){
            answer[i] = hm.get(temp[i]);
        }

        return answer;
    }
}
