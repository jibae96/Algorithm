import java.util.*;
import java.io.*;

public class Game2048easy{
    static int N;
    static int[][] map;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        map = new int [N][N];
        answer = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        start(0);
        System.out.println(answer);
    }
    
    public static void start(int count){
        if(count==5){
            findMax();
            return;
        }
        
        int[][] temp = new int[N][N];
        for(int i=0; i<N; i++){
            temp[i] = map[i].clone();
        }
        
        for(int i=0; i<4; i++){
            move(i);
            start(count+1);
            for(int j=0; j<N; j++){
                map[j] = temp[j].clone();
            }
        }
        
    }
    
    public static void move(int num){
        switch(num){
            case 0 : // 상
                for(int i=0; i<N; i++){
                    int index = 0;
                    int current = 0;
                    for(int j=0; j<N; j++){
                        if(map[j][i]!=0){
                            if(current == map[j][i]){
                                map[index-1][i] = current*2;
                                current = 0;
                                map[j][i] = 0;
                            }else{
                                current = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = current;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 1 : // 하
                for(int i=0; i<N; i++){
                    int index = N-1;
                    int current = 0;
                    for(int j=N-1; j>=0; j--){
                        if(map[j][i]!=0){
                            if(current == map[j][i]){
                                map[index+1][i] = current*2;
                                current = 0;
                                map[j][i] = 0;
                            }else{
                                current = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = current;
                                index--;
                            }
                        }
                    }
                }
                break;
            case 2 : 
                for(int i=0; i<N; i++){
                    int index = 0;
                    int current = 0;
                    for(int j=0; j<N; j++){
                        if(map[i][j]!=0){
                            if(current == map[i][j]){
                                map[i][index-1] = current*2;
                                current = 0;
                                map[i][j] = 0;
                            }else{
                                current = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = current;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 3 :
                for(int i=0; i<N; i++){
                    int index = N-1;
                    int current = 0;
                    for(int j=N-1; j>=0; j--){
                        if(map[i][j]!=0){
                            if(current == map[i][j]){
                                map[i][index+1] = current*2;
                                current = 0;
                                map[i][j] = 0;
                            }else{
                                current = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = current;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }

    public static void findMax(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                answer = Math.max(answer, map[i][j]);
            }
        }
    }
}
