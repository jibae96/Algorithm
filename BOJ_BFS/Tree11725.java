import java.util.*;

public class Tree11725 {
    static ArrayList<Integer>[] list;
    public void dfs(int n, int[] parents){
        for(int item : list[n]){
            if(parents[item]==0){
                parents[item]=n;
                dfs(item,parents);
            }
        }
        //System.out.println("dfs("+n+")");
    }
    public static void main(String[] args) {
        int[] parents;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        parents = new int [N+1];
        list = new ArrayList[N+1];

        Tree11725 tree = new Tree11725();

        for(int i=0; i<=N; i++){
            list[i]=new ArrayList<Integer>();
        }
        for(int i=0; i<N-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }
        for(int i=1; i<=N; i++){
            tree.dfs(i,parents);
        }
        for(int i=2; i<=N; i++){
            System.out.println(parents[i]);
        }
    }
}
