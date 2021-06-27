import java.util.*;

class Delivery {
    class Info{
        int city;
        int distance;
        public Info(int city, int distance){
            this.city = city;
            this.distance = distance;
        }
    }
    ArrayList<Info> [] list;
    int k;
    int answer;
    int [] dist;
    PriorityQueue<Info> pq;
    public int solution(int N, int[][] road, int K) {
        answer = 0;
        list = new ArrayList [N+1];
        k = K;
        dist = new int [N+1];
        pq = new PriorityQueue<>((o1,o2)->{
            return o1.distance-o2.distance;
        });
        
        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<Info>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<road.length; i++){
            list[road[i][0]].add(new Info(road[i][1],road[i][2]));
            list[road[i][1]].add(new Info(road[i][0],road[i][2]));
        }

        dist[1] = 0;
        pq.add(new Info(1,0));
        
        djikstra();
        
        for(int i=1; i<dist.length; i++){
            //System.out.print(dist[i]+" ");
            if(dist[i]<=K) answer++;
        }
            

        return answer;
    }

    public void djikstra(){
        while(!pq.isEmpty()){
            Info current = pq.poll();
            
            for(Info temp : list[current.city]){
                if(dist[temp.city] > dist[current.city]+temp.distance){
                    dist[temp.city] = dist[current.city]+temp.distance;
                    pq.add(temp);
                }
            }
        }
    }
}
