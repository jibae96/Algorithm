class HanoiTower {
    int index;
    int[][] answer;

    public int[][] solution(int n) {
        answer = new int [(int)Math.pow(2,n)-1][2];
        index = 0;

        hanoi(n, 1, 3, 2);

        return answer;
    }

    // start에서 end로 temp를 거쳐서
    public void hanoi(int n, int start, int end, int temp){
        if(n==1){
            move(n, start, end);
            return;
        }

        hanoi(n-1, start, temp, end);
        move(n, start, end);
        hanoi(n-1, temp, end, start);
    }

    public void move(int n, int start, int end){
        //System.out.println(start+","+end);

        answer[index][0] = start;
        answer[index][1] = end;
        index++;
    }
}
