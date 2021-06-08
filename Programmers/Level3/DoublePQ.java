import java.util.*;

class DoublePQ {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> pqmin = new PriorityQueue<>();
        PriorityQueue<Integer> pqmax = new PriorityQueue<>((o1,o2)->{
            return o2-o1;
        });

        for(String oper : operations){
            String [] temp = oper.split(" ");
            switch(temp[0]){
                case "I" :
                    pqmin.add(Integer.parseInt(temp[1]));
                    pqmax.add(Integer.parseInt(temp[1]));
                    break;
                case "D" :
                    if(temp[1].equals("-1") && !pqmin.isEmpty()){
                        int delete = pqmin.poll();
                        pqmax.remove(delete);
                    }else if(temp[1].equals("1") && !pqmax.isEmpty()) {
                        int delete = pqmax.poll();
                        pqmin.remove(delete);
                    }
                    break;
            }
        }

        if(!pqmax.isEmpty() && !pqmin.isEmpty()){
            answer[0] = pqmax.poll();
            answer[1] = pqmin.poll();
        }

        return answer;
    }

}
