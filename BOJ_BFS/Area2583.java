import java.util.*;

public class Area2583 {
    static int N;
    static int M;
    static int[][] array;
    int count=0;
    int areaSize=0;
    Queue<MyDot> queue;
    boolean[][] visited;
    int[] goX={-1,0,1,0};
    int[] goY={0,1,0,-1};

    class MyDot{
        int x;
        int y;
        public MyDot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void solution(int[][] array){
        ArrayList<Integer> list = new ArrayList<>();
        int[] arealist;
        queue = new LinkedList<>();
        visited = new boolean[N][M];
        for(int i=0; i<array.length; i++){ //5
            for(int j=0; j<array[i].length; j++){ //7
                if(!visited[i][j] && array[i][j]==0){
                    areaSize=1;
                    bfs(i,j);
                    list.add(areaSize);
                    visited[i][j]=true;
                    count++;
                }
            }
        }
        System.out.println(count);
        arealist = new int[count];
        for(int i=0; i<count; i++){
            arealist[i]=list.get(i);
        }
        Arrays.sort(arealist);
        for(int i=0; i<count; i++)
            System.out.print(arealist[i]+" ");

    }

    public void bfs(int a, int b){
        queue.add(new MyDot(a,b));
        visited[a][b]=true;
        while(!queue.isEmpty()){
            MyDot dot = queue.poll();
            System.out.println("dot="+dot.x+", "+dot.y);
            for(int i=0; i<4; i++) {
                int cx = dot.x+goX[i];
                int cy = dot.y+goY[i];
                if(cx>=0 && cx<N && cy>=0 && cy<M){
                    if(!visited[cx][cy] && array[cx][cy]==0){
                        areaSize++;
                        visited[cx][cy]=true;
                        queue.add(new MyDot(cx,cy));
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        array = new int [n][m];
        N=n; // 5
        M=m; // 7
        int rect = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<rect; i++){
            int temp1 = sc.nextInt(); // 4
            int temp2 = sc.nextInt(); // 0
            int temp3 = sc.nextInt(); // 6
            int temp4 = sc.nextInt(); // 2
            for(int a=n-temp4; a<n-temp2; a++){ // 3,4
                for(int b=temp1; b<temp3;b++){ // 4,5
                    array[a][b]=1;
                }
            }
        }
        for(int i=0; i<n; i++){ // 5
            for(int j=0; j<m; j++){ // 7
                System.out.print(array[i][j]+" ");
            }
            System.out.println("");
        }
        Area2583 area = new Area2583();
        area.solution(array);
    }
}
