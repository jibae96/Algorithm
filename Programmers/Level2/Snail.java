public class Snail {
    public int[] solution(int n) {
        int[] answer;
        int num = 1;
        int row = -1;
        int col = 0;
        int count = 0;
        int cur = 0;
        for(int i=1; i<=n; i++)
            count += i;
        answer = new int [count];

        int[][]temp = new int[n][n];
        while(n!=0){
            for(int i=0; i<n; i++){
                row++;
                temp[row][col]=num;
                num++;
            }
            n--;
            if(n==0) break;
            for(int i=0; i<n; i++){
                col++;
                temp[row][col]=num;
                num++;
            }
            n--;
            if(n==0) break;
            for(int i=0; i<n; i++){
                row--;
                col--;
                temp[row][col]=num;
                num++;
            }
            n--;
            if(n==0) break;
        }

        for(int i=0; i<temp.length; i++){
            for(int j=0; j<temp.length; j++){
                if(temp[i][j]!=0) {
                    answer[cur]=temp[i][j];
                    cur++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Snail snail = new Snail();
        snail.solution(4);
    }
}
