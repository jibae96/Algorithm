import java.util.*;

class Lineup {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long total = 1;

        for(int i=1; i<=n; i++) {
            list.add(i);
            total *= i;
        }
        k--;

        for(int i=0; i<answer.length; i++) {
            total /= n;
            n--;

            int index = (int)(k / total);
            answer[i] = list.get(index);
            list.remove(index);

            k  %= total;
        }

        return answer;
    }
}
