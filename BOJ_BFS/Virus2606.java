import java.util.*;

public class Virus2606 {
    static int[][] map;
    static boolean[] visited;

    public void bfs(){
        int count=0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[0]=true;
        while(!queue.isEmpty()){
            int temp = queue.poll()-1;
            for(int i=0; i<map.length; i++){
                if(!visited[i] && map[temp][i]==1){
                    visited[i]=true;
                    queue.add(i+1);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N];
        int relations = sc.nextInt();
        for(int i=0; i<relations; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            map[a][b] = map[b][a] = 1;
        }
        Virus2606 virus = new Virus2606();
        virus.bfs();
    }
}
