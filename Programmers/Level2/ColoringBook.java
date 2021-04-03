public class ColoringBook {
    public static boolean[][] visited;
    public static int M; // 세로
    public static int N; // 가로
    public static int area;
    public static int[] goX = {-1,0,1,0};
    public static int[] goY = {0,1,0,-1};
    public void dfs(int[][] picture, int x, int y){
        area++;
        visited[x][y]=true;
        for(int i=0; i<4; i++){
            int tempX = x+goX[i];
            int tempY = y+goY[i];
            if(tempX>=0 && tempY>=0 && tempX<M && tempY<N){
                if(visited[tempX][tempY]==false && picture[x][y]==picture[tempX][tempY]){
                    dfs(picture,tempX,tempY);
                }
            }
        }
    }
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        M = m;//6
        N = n;//4
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && picture[i][j]!=0){
                    area = 0;
                    dfs(picture, i, j);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,area);
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int [][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        ColoringBook cb = new ColoringBook();
        cb.solution(m,n,picture);

    }
}
