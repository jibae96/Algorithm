import java.util.*;

public class MaxMin {
    public String solution(String s) {
        String answer = "";
        // s값 split해서 int[] 배열에 넣기
        // 최대최소값 구하기
        String[] numbers = s.split(" ");
        int[] nums = new int [numbers.length];
        for(int i=0; i<numbers.length; i++){
            nums[i] = Integer.parseInt(numbers[i]);
        }
        Arrays.sort(nums);
        answer += nums[0];
        answer += " ";
        answer += nums[nums.length-1];
        return answer;
    }

    public static void main(String[] args) {
        MaxMin maxMin = new MaxMin();
        String s1 = "1 2 3 4";
        String s2 = "-1 -2 -3 -4";
        maxMin.solution(s1);
        maxMin.solution(s2);
    }
}
