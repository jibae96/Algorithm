import java.util.*;

class Structure {
    boolean[][] pillar;
    boolean[][] bar;
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        pillar = new boolean [n+1][n+1]; // 기둥
        bar = new boolean[n+1][n+1]; // 보
        int x,y,a,b;
        int count = 0;
        
        for(int i=0; i<build_frame.length; i++){
            x = build_frame[i][0];
            y = build_frame[i][1];
            a = build_frame[i][2];
            b = build_frame[i][3];
            
            
            if(b==1){ // 설치
                if(a==0){ // 기둥
                    if(checkPillar(x,y)){
                        pillar[x][y] = true;
                        count++;
                    }
                }else{ // 보
                    if(checkBar(x,y)){
                        bar[x][y] = true;
                        count++;
                    }
                }
                
            }else{ // 삭제
                if(a==0){ // 기둥
                    pillar[x][y] = false;
                    if(!checkDelete(n)) pillar[x][y] = true;
                    else count--;
                }else{ // 보
                    bar[x][y] = false;
                    if(!checkDelete(n)) bar[x][y] = true;
                    else count--;
                }
            }
        }
        
        answer = new int [count][3];
        int index = 0;
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(pillar[i][j]){
                    answer[index][0] = i;
                    answer[index][1] = j;
                    answer[index++][2] = 0;
                }
                if(bar[i][j]){
                    answer[index][0] = i;
                    answer[index][1] = j;
                    answer[index++][2] = 1;
                }
            }
        }
        
        return answer;
    }
    
    public boolean checkPillar(int x, int y){
        if(y==0) return true; // 기둥을 바닥에 설치
        else if(y>0 && pillar[x][y-1]) return true; // 아래에 기둥이 있을 때
        else if(x>0 && bar[x-1][y] || bar[x][y]) return true; // 보가 있고 그 아래 기둥 세울 때
        return false;
    }
    
    public boolean checkBar(int x, int y){
        if(y>0 && pillar[x][y-1] || pillar[x+1][y-1]) return true; // 양 옆 중 하나에 기둥이 있을 때
        else if(x>0 && bar[x-1][y] && bar[x+1][y]) return true; // 양 옆 모두에 보가 있을 때
        return false;
    }
    
    public boolean checkDelete(int n){
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(pillar[i][j] && !checkPillar(i,j)) return false;
                else if(bar[i][j] && !checkBar(i,j)) return false;
            }
        }
        
        return true;
    }
}
