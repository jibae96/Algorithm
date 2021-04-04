import java.util.*;

// HashMap hm
// hm.keySet()
// hm.values()

public class Spy {
    public int solution(String[][] clothes) {
        int answer =1;
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i=0; i<clothes.length; i++){
            hm.put(clothes[i][1],hm.getOrDefault(clothes[i][1],0)+1);
        }

        for(int n : hm.values()){
            answer *= n+1;
        }

        return answer-1;
    }

    public static void main(String[] args) {
        Spy spy = new Spy();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        spy.solution(clothes);
    }
}
