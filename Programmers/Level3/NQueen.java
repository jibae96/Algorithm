import java.util.*;

class NQueen {
    boolean[] visited;
    int [] pick;
    int count;
    
    public int solution(int n) {
        int answer = 0;
        visited = new boolean[n];
        pick = new int [n];
        count = 0;
        
        travel(n,0);
        
        return count;
    }
    
    public void travel(int n, int index){
        
        if(n==index){
            count++;
            return;
        }
        
        for(int i=0; i<n; i++){
            if(visited[i]==false){
                visited[i] = true;
                pick[index] = i;
                if(check(index)) travel(n,index+1);
                visited[i] = false;
            }
        }
    }
    
    public boolean check(int index){
        for(int i=0; i<index; i++){
            if(pick[i]==pick[index]) return false;
            if(Math.abs(index-i)==Math.abs(pick[index]-pick[i])) return false; // 대각선
        }
        return true;
    }
}
