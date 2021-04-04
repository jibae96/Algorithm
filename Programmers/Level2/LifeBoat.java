import java.util.*;

public class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int min=0;
        Arrays.sort(people);

        for(int max=people.length-1; max>= min; max--){
            if(people[min] + people[max] <= limit) min++;
            answer++;
        }

        System.out.println(answer+"!");

        return answer;
    }

    public static void main(String[] args) {
        LifeBoat lifeBoat = new LifeBoat();
        int[] people1 = {70,50,80,50};
        int[] people2 = {70,80,50};
        int[] people3 = {20,30,50,70};
        int limit=100;
        lifeBoat.solution(people1, limit);
        lifeBoat.solution(people2, limit);
        lifeBoat.solution(people3, limit);
    }
}
