// 3차원 배열 사용
class Paradise {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {

        int[][][] way = new int[m+1][n+1][2]; // [0]:right [1]:bottom
        way[1][1][0] = way[1][1][1] = 1;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(cityMap[i-1][j-1]==0){
                    way[i][j][0] += (way[i-1][j][0] + way[i][j-1][1])%MOD;
                    way[i][j][1] += (way[i-1][j][0] + way[i][j-1][1])%MOD;
                }else if(cityMap[i-1][j-1]==1){
                    way[i][j][0] = way[i][j][1] = 0;
                }else if(cityMap[i-1][j-1]==2){
                    way[i][j][0] = way[i-1][j][0];
                    way[i][j][1] = way[i][j-1][1];
                }
            }
        }

        return way[m][n][0]%MOD;
    }
}
