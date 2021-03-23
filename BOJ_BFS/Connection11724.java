import java.util.*;

public class Connection11724 {
    static int[][] map;
    boolean[] visited;
    public void solution(int n){
        visited = new boolean[n];
        int count=0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i,n);
                visited[i]=true;
                count++;
            }
        }
        System.out.println(count);
    }
    public void bfs(int index, int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i=0; i<n; i++){
                if(!visited[i] && map[temp][i]==1){
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int relations = sc.nextInt();
        sc.nextLine();
        map = new int[N][N];
        for(int i=0; i<relations; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            map[a][b]=map[b][a]=1;
        }
        Connection11724 connection = new Connection11724();
        connection.solution(N);
    }
}
