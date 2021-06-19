import java.util.*;

class AddTwo {
    HashSet<Integer> hs;
    public void combination(int[] numbers, boolean[] visited, int start, int r){
        int result = 0;

        if(r==0){
            for(int i=0; i<numbers.length; i++){
                if(visited[i]){
                    result += numbers[i];
                }
            }
            hs.add(result);
            return;
        }else{
            for(int i=start; i<numbers.length; i++){
                visited[i] = true;
                combination(numbers,visited,i+1, r-1);
                visited[i] = false;
            }
        }

    }
    public int[] solution(int[] numbers) {
        int[] answer;
        boolean [] visited = new boolean[numbers.length];
        hs = new HashSet<>();

        combination(numbers,visited,0,2);

        answer = new int [hs.size()];
        int index = 0;

        for(int temp : hs){
            answer[index++] = temp;
        }

        Arrays.sort(answer);

        return answer;
    }
}
