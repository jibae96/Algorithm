import java.util.*;

class MakeZero {
    ArrayList<Integer>[] list;
    int[] in;
    boolean[] visited;
    long[] score;
    long result;
    public long solution(int[] a, int[][] edges) {
        long total = 0;
        result = 0;
        list = new ArrayList[a.length];
        score = new long[a.length];

        for(int i=0; i<a.length; i++){
            total += a[i];
            score[i] = a[i];
            list[i] = new ArrayList<Integer>();
        }

        if(total!=0) return -1;

        in = new int[a.length];
        for(int i=0; i<edges.length; i++){
            int aa = edges[i][0];
            int bb = edges[i][1];
            list[aa].add(bb);
            list[bb].add(aa);
            in[aa]++;
            in[bb]++;
        }

        visited = new boolean[a.length];
        travel();

        return result;
    }
    public void travel(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<in.length; i++){
            if(in[i]==1) queue.add(i);
        }

        while(!queue.isEmpty()){
            int current = queue.poll();
            visited[current] = true;

            for(int i=0; i<list[current].size(); i++){
                int next = list[current].get(i);
                if(!visited[next]){
                    in[next]--;
                    score[next]+=score[current];
                    result += Math.abs(score[current]);
                    score[current]=0;
                    if(in[next]==1) queue.add(next);
                }
            }
        }
    }
}
