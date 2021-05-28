import java.util.*;

class FarNode {
    public int solution(int n, int[][] edge) {
        int answer = 1;
        ArrayList<Integer> [] list = new ArrayList [n+1];

        for(int i=0; i<n+1; i++)
            list[i] = new ArrayList<Integer>();

        for(int i=0; i<edge.length; i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        /*
        for(int i=0; i<list.length; i++){
            System.out.println(i+"--"+list[i]);
        }
        */

        int [] distance = new int [n+1];

        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[n+1];

        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int i=0; i<list[current].size(); i++){
                if(!visited[list[current].get(i)]){
                    distance[list[current].get(i)] = distance[current]+1;
                    visited[list[current].get(i)] = true;
                    queue.add(list[current].get(i));
                }
            }
        }

        Arrays.sort(distance);
        int max=distance[n];

        for(int i=n-1; i>=0; i--){
            if(distance[i]==max) answer++;
            else break;
        }
        return answer;
    }

}
