import java.util.*;

public class Tomato7576{
    int N;
    int M;
    int[][] arr;
    int count=0;
    int[] goX = {-1,0,1,0};
    int[] goY = {0,1,0,-1};
    Queue<MyDot> queue;
    static int noTomato = 0;
    static int current = 0;

    class MyDot{
        int x;
        int y;
        MyDot(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public void solution(int n, int m,int[][] array){
        N=n;
        M=m;
        arr=array;
        queue = new LinkedList<>();

        BFS(array);
    }

    public void BFS(int[][] array){
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(array[i][j]==1) {
                    queue.add(new MyDot(i,j));
                }
            }
        }

        while(!queue.isEmpty()){
            MyDot dot = queue.poll();
            for(int i=0; i<4; i++){
                int tempX = dot.x+goX[i];
                int tempY = dot.y+goY[i];
                if(tempX>=0 && tempX<M && tempY>=0 && tempY<N){
                    if(arr[tempX][tempY]==0){
                        arr[tempX][tempY]=arr[dot.x][dot.y]+1;
                        queue.add(new MyDot(tempX,tempY));
                    }
                }
            }
        }

        int max=0;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j]==0){
                    System.out.println("-1");
                    return;
                }else{
                    max = Math.max(max,arr[i][j]);
                }
            }
        }
        System.out.println(max-1);
    }
    public static void main(String[] args) {
        Tomato7576 tomato = new Tomato7576();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //가로
        int m = scanner.nextInt(); //세로
        int[][] array = new int[m][n];
        scanner.nextLine();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int temp = scanner.nextInt();
                array[i][j]= temp;
                if(array[i][j]==-1) noTomato++;
            }
            scanner.nextLine();
        }
        tomato.solution(n,m,array);
    }
}
