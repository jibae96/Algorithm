import java.util.*;
public class Printer {
    class MyPrint{
        int priority;
        int location;
        public MyPrint(int priority, int location){
            this.priority = priority;
            this.location = location;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<MyPrint> queue = new LinkedList<>();
        int index = 0;
        int indexMax = priorities.length-1;
        int[] maxPriority = new int [priorities.length];
        int printOrder = 0; // 프린트되는 순서
        for(int temp : priorities){
            queue.add(new MyPrint(temp,index));
            maxPriority[index]=temp;
            index++;
        }
        Arrays.sort(maxPriority);
        while(!queue.isEmpty()){
            MyPrint current = queue.poll();
            if(current.priority<maxPriority[indexMax]){
                queue.add(current);
            }else{
                printOrder++;
                if(current.location==location){
                    return printOrder;
                }else{
                    indexMax--;
                }
            }
        }
        return printOrder;
    }

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        Printer printer = new Printer();
        printer.solution(priorities,location);
    }
}
