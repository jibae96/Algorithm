public class Covid_ {
    int answer;
    int[] goX = {0,1,0,-1}; // 우아래좌위
    int[] goY = {1,0,-1,0};
    boolean[][] visited;
    public int solution(int[][] places){
        answer = 1;
        visited = new boolean[places.length][places[0].length];

        for(int i=0; i<places.length; i++){
            for(int j=0; j<places[0].length; j++){
                if(places[i][j]==2){
                    visited[i][j] = true;
                    dfs(places, i, j, 0);
                    visited[i][j] = false;
                }
            }
        }

        System.out.println(answer+"!");
        return answer;
    }

    public void dfs(int[][] map, int x, int y, int count){

        if(count>2) return;
        if(count>0 && count<=2 && map[x][y]==2){
            answer = 0;
            return;
        }
        for(int i=0; i<4; i++){
            int tempX = x + goX[i];
            int tempY = y + goY[i];

            if(tempX>=0 && tempX<map.length && tempY>=0 && tempY<map[0].length){
                if(map[tempX][tempY]!=0){
                    if(visited[tempX][tempY]) continue;
                    visited[tempX][tempY] = true;
                    dfs(map, tempX, tempY, count+1);
                    visited[tempX][tempY] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] place1 = {{2,1,1,1,2},{1,0,0,1,0},{1,2,0,2,0},{1,1,0,1,0},{2,1,0,0,2}};
        int[][] place2 = {{1,0,2,0,2},{2,0,0,0,1},{1,0,0,0,1},{1,1,1,2,2}};

        Covid covid = new Covid();

        System.out.println("1이면 가능 0이면 불가능!");

        covid.solution(place1);
        covid.solution(place2);
    }
}
