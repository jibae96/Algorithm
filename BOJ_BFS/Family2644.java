import java.util.*;

public class Family2644 {
    static int[][] family;
    public void solution(int a, int b){
        int [] visited = new int[family.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i=0; i<family.length; i++){
                if(family[temp][i]==1 && visited[i]==0){
                    queue.add(i);
                    visited[i]=visited[temp]+1;
                }
            }
        }
        if(visited[b]==0){
            System.out.println("-1");
            return;
        }
        System.out.println(visited[b]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        family = new int[total][total];
        int a = sc.nextInt()-1;
        int b = sc.nextInt()-1;
        int relations = sc.nextInt();
        for(int i=0; i<relations; i++){
            int x=sc.nextInt()-1;
            int y=sc.nextInt()-1;
            family[x][y] = family[y][x] = 1;
        }
        Family2644 family = new Family2644();
        family.solution(a,b);
    }
}
