import java.util.*;

public class Nexpression {
    //N을 i개를 사용하여 만들 수 있는 숫자를 해시셋에 넣는다..
    HashSet<Integer>[] dp = new HashSet [9];

    public int solution(int N, int number) {

        if(N==number) return 1;
        String NtoString = ""+N;
        for(int i=0; i<=8; i++){
            dp[i] = new HashSet<Integer>();
            if(i==1) dp[i].add(Integer.parseInt(NtoString));
            if(i<2) continue;

            NtoString += ""+N;
            dp[i].add(Integer.parseInt(NtoString));
            for(int j=1; j<i; j++){
                check(j,i);
                if(dp[i].contains(number)) return i;
            }
        }
        return -1;
    }

    public void check(int a, int b){
        Iterator<Integer> listA = dp[a].iterator();
        Iterator<Integer> listB = dp[b-a].iterator();

        while(listA.hasNext()){
            int tempA = listA.next();

            while(listB.hasNext()){
                int tempB = listB.next();

                dp[b].add(tempA+tempB);
                dp[b].add(tempA-tempB);
                dp[b].add(tempA*tempB);
                if(tempB!=0) dp[b].add(tempA/tempB);
            }

            listB = dp[b-a].iterator();
        }
    }
    public static void main(String[] args) {
        Nexpression expression = new Nexpression();
        expression.solution(5,12);
    }
}
