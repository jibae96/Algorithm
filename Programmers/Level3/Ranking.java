import java.util.*;

class Ranking {
    boolean [] visited;
    List<Integer> [] win;
    List<Integer> [] lose;
    int count;
    public int solution(int n, int[][] results) {
        int answer = 0;
        win = new LinkedList [n];
        lose = new LinkedList [n];

        for(int i=0; i<n; i++){
            win[i] = new LinkedList<>();
            lose[i] = new LinkedList<>();
        }

        for(int i=0; i<results.length; i++){
            int winPerson = results[i][0]-1;
            int losePerson = results[i][1]-1;
            win[winPerson].add(losePerson);
            lose[losePerson].add(winPerson);
        }

        for(int i=0; i<n; i++){
            int sum = 0;
            count = 0;
            visited = new boolean[n];
            check(i,win);
            sum = count;
            count = 0;
            visited = new boolean[n];
            check(i,lose);
            sum += count;

            if(sum==n-1) answer++;
        }
        return answer;
    }

    public void check(int v, List<Integer>[] graph){
        visited[v]=true;
        for(int temp : graph[v]){
            if(!visited[temp]){
                count++;
                check(temp,graph);
            }
        }
    }
}
