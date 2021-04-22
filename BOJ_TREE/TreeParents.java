import java.io.*;
import java.util.*;

public class TreeParents{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testcase = Integer.parseInt(st.nextToken());

        ArrayList<Integer> [] list = new ArrayList[testcase+1];
        for(int i=1; i<=testcase; i++)
            list[i]=new ArrayList<Integer>();

        for(int i=0; i<testcase-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);

        }

        int [] parents = new int [testcase+1];

        dfs(list, parents, testcase,1,0);

        for(int i=2; i<=testcase; i++)
            System.out.println(parents[i]);
    }

    public static void dfs(ArrayList<Integer>[] list, int[] parents, int n, int start, int parent){
        parents[start]=parent;
        for(int item : list[start]){
            if(item!=parent)
                dfs(list, parents, n, item, start);
        }
    }
}
