import java.util.*;

class MakePrime {
    ArrayList<Integer> list;
    public void check(int [] array, boolean [] visited){
        int result = 0;
        for(int i=0; i<visited.length; i++){
            if(visited[i]) result += array[i];
        }

        list.add(result);
    }
    public void combination(int[] nums, boolean[] visited, int start, int r){
        if(r==0){
            check(nums,visited);
            return;
        }else{
            for(int i=start; i<nums.length; i++){
                visited[i] = true;
                combination(nums,visited,i+1,r-1);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int temp){
        for(int i=2; i<=temp/2; i++){
            if(temp%i==0) return false;
        }
        return true;
    }

    public int solution(int[] nums) {
        int answer = -1;
        int count = 0;

        list = new ArrayList<>();
        boolean [] visited = new boolean[nums.length];

        combination(nums, visited,0,3);

        for(int temp : list){
            if(isPrime(temp)){
                count++;
            }
        }

        return count;
    }
}
