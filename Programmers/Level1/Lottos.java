import java.util.*;

class Lottos {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int [2];
        int blank = 0;
        int count = 0;

        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<lottos.length; i++){
            if(lottos[i]==0)
                blank++;
            else hs.add(lottos[i]);
        }

        for(int i=0; i<win_nums.length; i++){
            if(hs.contains(win_nums[i])){
                hs.remove(win_nums[i]);
                count++;
            }
        }
        int min = count;
        int max = (count+blank>win_nums.length)? win_nums.length : count+blank;

        answer[0] = (7-max>5) ? 6 : 7-max;
        answer[1] = (7-min>5) ? 6 : 7-min;

        return answer;
    }
}
