import java.util.*;

// 우선순위 큐 사용 (효율)

public class Spicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int temp : scoville) pq.add(temp);

        while(pq.peek()<=K){
            if(pq.size()==1) return -1;
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a+b*2);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Spicy spicy = new Spicy();
        int [] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        spicy.solution(scoville,K);
    }
}
