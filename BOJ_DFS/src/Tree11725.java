import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tree11725 {
    static int n;
    static ArrayList<Integer>[] trees;
    static int [] parents;
    static void dfs(int start, int parent){
        parents[start]=parent;
        for(int temp : trees[start]){
            if(temp != parent) dfs(temp,start);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        trees = new ArrayList[n+1];
        for(int i=1; i<n+1; i++){
            trees[i]=new ArrayList<>();
        }
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            trees[x].add(y);
            trees[y].add(x);
        }
        parents = new int[n+1];
        dfs(1,0);
        for(int i=2; i<=n; i++)
            System.out.println(parents[i]);
    }
}
