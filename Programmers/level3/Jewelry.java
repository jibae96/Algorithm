import java.util.*;

public class Jewelry {
    public int[] solution(String[] gems) {
        int[] answer = new int [2];
        HashSet<String> hs = new HashSet<>();
        HashMap<String, Integer> hm = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        int startPoint = 0;
        int length = gems.length;

        for(String gem : gems)
            hs.add(gem);

        int start=0;
        for(int i=0; i<gems.length; i++){
            if(!hm.containsKey(gems[i])) hm.put(gems[i], 1);
            else hm.put(gems[i], hm.get(gems[i]) + 1);

            queue.add(gems[i]);

            while(true){
                String temp = queue.peek();
                System.out.println(temp);
                if(hm.get(temp)>1){
                    hm.put(temp, hm.get(temp)-1);
                    queue.poll();
                    startPoint++;
                }else break;
            }

            if(hm.size() == hs.size() && length > queue.size()){
                length = queue.size();
                start = startPoint;
            }
        }
        answer[0] = start+1;
        answer[1] = start+length;

        System.out.println(answer[0]+" "+answer[1]+"!");
        return answer;
    }
    public static void main(String[] args) {
        Jewelry jewelry = new Jewelry();
        String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems2 = {"DIA","EM","EM","RUB","DIA"};
        jewelry.solution(gems2);
    }
}
