import java.util.*;
// length : 배열 길이
// length() : 문자열 길이
// size() : 컬랙션 타입 길이
public class Bridge {
    class MyTruck{
        int weight;
        int move;
        public MyTruck(int weight, int move){
            this.weight = weight;
            this.move = move;
        }
        public void moving(){
            this.move++;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;
        int index = 0;
        Queue<MyTruck> queue = new LinkedList<>();
        ArrayList<MyTruck> startList = new ArrayList<>();
        ArrayList<MyTruck> finishList = new ArrayList<>();

        for(int temp : truck_weights){
            startList.add(new MyTruck(temp, 1));
        }
        queue.add(startList.get(index));
        totalWeight += startList.get(index).weight;
        index++;
        while(!queue.isEmpty() || finishList.size()<truck_weights.length){
            for(MyTruck temp : queue){
                temp.moving();
            }
            if(queue.peek().move>bridge_length){
                MyTruck finish = queue.poll();
                finishList.add(finish);
                totalWeight -= finish.weight;
            }
            if(index<truck_weights.length){
                if(totalWeight + startList.get(index).weight <= weight){
                    queue.add(startList.get(index));
                    totalWeight += startList.get(index).weight;
                    index++;
                }
            }

            answer++;
        }
        return answer+1;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight  = 10;
        int[] truck_weights={7,4,5,6};
        Bridge bridge = new Bridge();
        bridge.solution(bridge_length,weight,truck_weights);
    }
}
