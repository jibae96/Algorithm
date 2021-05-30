import java.util.*;

public class Entrance {
    public long solution(int n, int[] times) {

        Arrays.sort(times);
        long answer = (long)n*times[times.length-1];
        long start, end, mid;

        start = 0;
        end = (long)n*times[times.length-1];

        long sum; // 주어진 시간(mid) 동안 심사받을 수 있는 사람 수

        while(start<=end){
            mid = (start+end)/2;
            sum = 0;

            for(int i=0; i<times.length; i++){
                sum += mid/times[i];

                if(sum >= n) break;
            }

            if(sum >= n){
                end = mid - 1;
                answer = Math.min(answer,mid);
            }else{
                start = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int [] times = {7,10};
        Entrance entrance = new Entrance();
        entrance.solution(6,times);
    }
}
