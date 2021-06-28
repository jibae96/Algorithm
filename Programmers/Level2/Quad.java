class Quad {
    int zero;
    int one;
    public int[] solution(int[][] arr) {
        int[] answer = new int [2];
        zero = 0;
        one = 0;

        compress(arr,0,0,arr.length);
        answer[0] = zero;
        answer[1] = one;
        return answer;
    }

    public void compress(int[][] array, int x, int y, int len){
        if(array.length==1){
            if(array[x][y]==0) zero++;
            else one++;
            return;
        }

        boolean flag = true;
        int temp = array[x][y];
        for(int i=x; i<x+len; i++){
            if(flag){
                for(int j=y; j<y+len; j++){
                    if(array[i][j]!=temp){
                        flag = false;
                        break;
                    }
                }
            }
        }

        if(flag){
            if(temp==1) one++;
            else zero++;
        }else{
            len /= 2;
            compress(array,x,y,len);
            compress(array,x+len,y,len);
            compress(array,x,y+len,len);
            compress(array,x+len,y+len,len);
        }
    }
}
