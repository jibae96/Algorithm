import java.util.*;

public class Apartment2667 {
    int[][] array;
    int N;
    Queue<MyDot> queue;
    boolean[][] visited;
    int tempSize=0;
    int[] goX = {-1,0,1,0};
    int[] goY = {0,1,0,-1};

    public class MyDot{
        int x;
        int y;
        public MyDot(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public void solution(int[][] arr){
        array = arr;
        N = arr.length;
        visited = new boolean[N][N];
        queue = new LinkedList<>();
        int count=0;
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                if(!visited[i][j] && array[i][j]!=0){
                    tempSize=1;
                    BFS(i,j);
                    count++;
                    list.add(tempSize);
                }
            }
        }
        answer = new int [count];
        for(int i=0; i<count; i++){
            answer[i]=list.get(i);
        }
        Arrays.sort(answer);
        System.out.println(count);
        for(int i=0; i<answer.length; i++)
            System.out.println(answer[i]);
    }
    public void BFS(int a, int b){
        queue.add(new MyDot(a,b));
        visited[a][b]=true;
        while(!queue.isEmpty()){
            MyDot dot = queue.poll();
            for(int i=0; i<4; i++){
                int tempX = dot.x+goX[i];
                int tempY = dot.y+goY[i];
                if(tempX>=0 && tempX<N && tempY>=0 && tempY<N){
                    if(!visited[tempX][tempY] && array[a][b]==array[tempX][tempY]){
                        queue.add(new MyDot(tempX,tempY));
                        visited[tempX][tempY]=true;
                        tempSize++;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Apartment2667 apartment = new Apartment2667();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            String str = scanner.nextLine();
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }
        apartment.solution(arr);
    }
}
