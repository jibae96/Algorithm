import java.util.*;

class Covid {
    int [] goX = {-1,0,1,0};
    int [] goY = {0,1,0,-1};
    int [] goXX = {-1,1,1,-1};
    int [] goYY = {1,1,-1,-1};
    int [] goXXX = {-2,0,2,0};
    int [] goYYY = {0,2,0,-2};
    
    public int[] solution(String[][] places) {
        int[] answer = new int [places.length];
        String[][] map = new String[5][5];
        int index = 0;
        
        for(String[] place : places){
            //check(place,answer,index++);

            for(int i=0; i<place.length; i++){
                //System.out.print(place[i]+" ");
                
                for(int j=0; j<place[i].length(); j++){
                    map[i][j] = place[i].substring(j,j+1);
                    //System.out.print(map[i][j]+" ");
                }
                //System.out.println();
            }
            
            answer[index++] = check(map);
        }
        
        return answer;
    }
    
    public int check(String[][] map){
        
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(map[i][j].equals("P")){
                    for(int k=0; k<4; k++){
                        int tempX = i + goX[k];
                        int tempY = j + goY[k];
                        if(tempX>=0 && tempX<5 && tempY>=0 && tempY<5){
                            if(map[tempX][tempY].equals("P"))
                                return 0;
                        }
                    }
                    for(int k=0; k<4; k++){
                        int tempX = i + goXX[k];
                        int tempY = j + goYY[k];
                        
                        if(tempX>=0 && tempX<5 && tempY>=0 && tempY<5){
                            if(map[tempX][tempY].equals("P")){
                                if(k==0){
                                    if(map[i-1][j].equals("X") && map[i][j+1].equals("X")){
                                        continue;
                                    }else return 0;
                                }else if(k==1){
                                    if(map[i+1][j].equals("X") && map[i][j+1].equals("X")){
                                        continue;
                                    }else return 0;
                                }else if(k==2){
                                    if(map[i][j-1].equals("X") && map[i+1][j].equals("X")){
                                        continue;
                                    }else return 0;
                                }else{
                                    if(map[i][j-1].equals("X") && map[i-1][j].equals("X")){
                                        continue;
                                    }else return 0;
                                }
                            }
                        }
                    }
                    
                    for(int k=0; k<4; k++){
                        int tempX = i + goXXX[k];
                        int tempY = j + goYYY[k];
                        if(tempX>=0 && tempX<5 && tempY>=0 && tempY<5){
                            if(map[tempX][tempY].equals("P")){
                                if(i+goX[k]>=0 && i+goX[k]<5 && j+goY[k]>=0 && j+goY[k]<5){
                                    if(map[i+goX[k]][j+goY[k]].equals("O"))
                                        return 0;
                                }
                                
                            }
                        }
                        
                    }
                }
                
            }
        }
        
        return 1;
    }
}
