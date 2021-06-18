import java.util.*;

class Ternary {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while(n!=0){
            list.add(n%3);
            n /= 3;
        }

        int th = 1;
        boolean flag = false;

        for(int i=list.size()-1; i>=0; i--){

            if(list.get(i)!=0 || flag){
                answer += th*list.get(i);
                th *= 3;
                flag = true;
            }
        }

        return answer;
    }
}
