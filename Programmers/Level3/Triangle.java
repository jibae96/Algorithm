import java.util.*;

class Triangle {
    public int solution(int[][] triangle) {
        
        int [] result = new int [triangle.length];

        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                //int temp = triangle[i][j];
                if(j!=0 && j!=triangle[i].length-1){
                    triangle[i][j] = Math.max(triangle[i][j]+triangle[i-1][j], triangle[i][j]+triangle[i-1][j-1]);
                }else if(j==0){
                    triangle[i][j] += triangle[i-1][j];
                }else if(j==triangle[i].length-1){
                    triangle[i][j] += triangle[i-1][j-1];
                }
            }
        }

        int index = 0;
        for(int num : triangle[triangle.length-1]){
            result[index] = num;
            index++;
        }

        Arrays.sort(result);

        return result[index-1];
    }
}
