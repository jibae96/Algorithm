import java.util.*;

// 반올림 Math.round
// 올림 Math.ceil
// 내림 Math.floor

public class FunctionDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Queue<Integer> queue = new LinkedList<>();
        int index = 0;
        int complete=0;
        ArrayList<Integer> list = new ArrayList<>();
        // progresses[i]+speeds[i]*x = 100 인 x를 큐에 넣기
        // 100-progresses[i] = 정수
        // speeds[i] = 정수
        // 정수 나누기 정수는 정수 -> 올림 효과 X -> (double) 필수!
        for(int temp : progresses){
            int day = (int)Math.ceil((100-temp)/(double)speeds[index]);
            index++;
            queue.add(day);
        }
        while(!queue.isEmpty()){
            int current = queue.poll();
            complete = 1;
            while(!queue.isEmpty() && queue.peek()<=current){
                queue.poll();
                complete++;
            }
            list.add(complete);
        }
        answer = new int [list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        FunctionDevelop fd = new FunctionDevelop();
        int[] processes = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        fd.solution(processes,speeds);
    }
}
