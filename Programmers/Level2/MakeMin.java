import java.util.*;
public class MakeMin {
    public int solution(int []A, int []B){
        int answer = 0;
        //sort 함수로 오름차순 정렬한 뒤
        //A에서 가장 작은 수부터 B에서는 가장 큰 수부터

        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length;
        for(int i=0; i<len; i++){
            answer += A[i]*B[len-i-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        MakeMin makeMin = new MakeMin();
        makeMin.solution(A,B);
    }
}
