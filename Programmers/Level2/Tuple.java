import java.util.*;

public class Tuple {
    public int[] solution(String s) {
        int[] answer;
        String temp= s.substring(1,s.length()-2);
        String[] numbers = temp.split("},");
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(numbers, (o1,o2)->{
            return o1.length()-o2.length();
        });

        for(int i=0; i<numbers.length; i++){
            numbers[i] = numbers[i].substring(1);
            String [] numm = numbers[i].split(",");
            for(String ch : numm){
                int n = Integer.parseInt(ch);
                if(!list.contains(n)) list.add(n);
            }
        }

        answer = new int [list.size()];
        int index=0;
        for(int N : list){
            answer[index] = list.get(index);
            index++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Tuple tuple = new Tuple();
        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s3 = "{{20,111},{111}}";
        String s4 = "{{123}}";
        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        tuple.solution(s1);
        tuple.solution(s2);
        tuple.solution(s3);
        tuple.solution(s4);
        tuple.solution(s5);
    }
}
