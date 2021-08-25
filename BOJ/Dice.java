import java.util.*;
import java.io.*;

public class Dice{
    static int[][] map;
    static int[] dice;
    static int[] goX = {0,0,-1,1}; // 동서북남
    static int[] goY = {1,-1,0,0};
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        dice = new int [7];
        sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        
        map = new int [n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<len; i++){
            int direction = Integer.parseInt(st.nextToken());
            int tempX = goX[direction-1] + x;
            int tempY = goY[direction-1] + y;
            
            if(tempX>=0 && tempX<n && tempY>=0 && tempY<m){
                moveDice(direction);
                
                x = tempX;
                y = tempY;

                if(map[x][y]==0){
                    map[x][y] = dice[6];
                }else{
                    dice[6] = map[x][y];
                    map[x][y] = 0;
                }
                
                sb.append(dice[1]+"\n");
            }
        }
        
        System.out.print(sb.toString());
    }
    
    public static void moveDice(int direction){
        int[] temp = dice.clone();
        //dice[6] = 밑면 , dice[1] = 윗면
        
        int top = dice[1];

        if(direction==1){ // 동
            dice[1] = temp[4];
            dice[4] = temp[6];
            dice[6] = temp[3];
            dice[3] = top;
        }else if(direction==2){ // 서
            dice[1] = temp[3];
            dice[3] = temp[6];
            dice[6] = temp[4];
            dice[4] = top;
        }else if(direction==3){ // 북
            dice[1] = temp[5];
            dice[5] = temp[6];
            dice[6] = temp[2]; 
            dice[2] = top;   
        }else{ // 남
            dice[1] = temp[2];
            dice[2] = temp[6];
            dice[6] = temp[5];
            dice[5] = top;
        }
    }
}
