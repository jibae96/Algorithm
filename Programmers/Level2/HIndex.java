import java.util.*;

public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations); // 0 1 3 5 6
        int index = citations[citations.length-1]; //index번
        int count = 0;//논문 count편
        while(index!=0){
            for(int i=citations.length-1; i>=0; i--){
                if(citations[i]>=index) count++;
            }
            if(count>=index) return index;
            index--;
            count=0;
        }
        return index;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        int[] citations = {3, 0, 6, 1, 5};
        hIndex.solution(citations);
    }
}
