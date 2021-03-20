import java.util.*;

public class BFSDFS1260 {
    static int[][] map;
    static boolean[] visited;
    public void dfs(int start){
        visited[start-1]=true;
        System.out.print(start+" ");
        for(int i=0; i<map.length; i++){
            if(!visited[i] && map[start-1][i]==1)
                dfs(i+1);
        }
    }
    public void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start-1]=true;
        System.out.print(start+" ");

        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i=0; i<map.length; i++){
                if(!visited[i] && map[temp-1][i]==1){
                    queue.add(i+1);
                    visited[i]=true;
                    System.out.print(i+1+" ");
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int relations = sc.nextInt();
        int start = sc.nextInt();
        map = new int[count][count];
        visited = new boolean[count];
        sc.nextLine();
        for(int i=0; i<relations; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            map[a][b]=map[b][a]=1;
        }
        BFSDFS1260 bfsdfs1260 = new BFSDFS1260();
        bfsdfs1260.dfs(start);
        visited = new boolean[count];
        System.out.println("");
        bfsdfs1260.bfs(start);
    }
}
