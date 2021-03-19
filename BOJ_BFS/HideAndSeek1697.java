import java.util.*;

public class HideAndSeek1697 {
    int[] visited = new int[100000];
    public void solution(int a, int b){
        if(a==b) System.out.println(0);
        else BFS(a,b);
    }
    public void BFS(int a, int b){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a]=1;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i=0; i<3; i++){
                int n;
                if(i==0){
                    n=temp-1;
                }else if(i==1){
                    n=temp+1;
                }else {
                    n = temp*2;
                }
                if(n==b){
                    System.out.println(visited[temp]);
                    return;
                }
                if(n>=0 && n<100000 && visited[n]==0){
                    queue.add(n);
                    visited[n] = visited[temp]+1;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        HideAndSeek1697 hideAndSeek = new HideAndSeek1697();
        hideAndSeek.solution(a,b);
    }
}
