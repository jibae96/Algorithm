import java.util.*;

public class Cache {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> cache = new LinkedList<>();

        if(cacheSize==0){
            return 5*cities.length;
        }
        for(int i=0; i<cities.length; i++){
            String temp = cities[i].toUpperCase();

            if(cache.contains(temp)){
                cache.remove(temp);
                cache.add(temp);
                answer++;
            }else{
                if(cache.size()>=cacheSize){
                    cache.poll();
                }
                cache.add(temp);
                answer += 5;
            }
        }
        return answer;
    }

}
