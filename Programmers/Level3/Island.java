import java.util.*;

class Island {
    int [] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int [n];
        
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1,o2)->{
            return o1[2]-o2[2];
        });
        
        for(int i=0; i<costs.length; i++){
            int island1 = findParent(costs[i][0]);
            int island2 = findParent(costs[i][1]);
            if(island1 != island2){
                parent[island2] = island1;
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
    
    public int findParent(int child){
        if(parent[child] == child){
            return child;
        }else{
            return parent[child] = findParent(parent[child]);
        }
    }
}
