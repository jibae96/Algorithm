import java.util.*;

class Network {
    public boolean[] visited;
    int[] goX = {-1,0,1,0};
    int[] goY = {0,1,0,-1};
    int N;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        N = n;
        
        for(int i=0; i<n; i++){
            if(visited[i]==false){
                dfs(computers,i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int[][] computers, int n){
        visited[n]=true;
        for(int i=0; i<N; i++){
            if(n!=i && computers[n][i]==1 && visited[i]==false)
                dfs(computers,i);
            
        }
    }
}
