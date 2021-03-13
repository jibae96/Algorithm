import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Tree1068 {
    static int n;
    static ArrayList<Integer>[] trees;
    static boolean [] visited;
    static int erase;
    static int leaf=0;
    static void dfs(int x){
        visited[x]=true;
        int child = 0;
        for(int i=0; i<trees[x].size(); i++){
            int temp = trees[x].get(i);
            if(visited[temp]==false && temp != erase){
                child++;
                dfs(temp);
            }
        }
        if(child==0)
            leaf++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        trees = new ArrayList[n];
        visited = new boolean[n];
        int root=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            trees[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent!=-1){
                trees[i].add(parent);
                trees[parent].add(i);
            }else root = i;
        }
        erase = Integer.parseInt(br.readLine());
        if(erase==root) System.out.println(0);
        else {
            dfs(root);
            System.out.println(leaf);
        }
    }
}
