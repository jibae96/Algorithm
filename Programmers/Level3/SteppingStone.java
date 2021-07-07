class SteppingStone {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 0;
        int max = Integer.MAX_VALUE;
        
        while(min<=max){
            int mid = (min + max) / 2; // 건널 수 있는 사람 수로 이진 탐색
            if(cross(mid,k,stones)){
                min = mid + 1;
                answer = mid;
            }else max = mid - 1;
        }
        
        return answer;
    }
    
    public boolean cross(int mid, int k, int[] stones){
        int count = 0;
        
        for(int i=0; i<stones.length; i++){
            if(stones[i] < mid){
                count++;
                if(count>=k) return false;
            }else count = 0;
        }
        
        return true;
    }
}
