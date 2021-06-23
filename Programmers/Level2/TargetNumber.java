class TargetNumber {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer = bfs(numbers, target, numbers[0], 1) + bfs(numbers, target,-numbers[0],1);

        return answer;
    }

    public int bfs(int[] array, int target, int sum, int index){
        if(index==array.length){
            if(sum==target) return 1;
            else return 0;
        }
        int result = 0;
        result += bfs(array,target,sum+array[index],index+1);
        result += bfs(array,target,sum-array[index],index+1);
        return result;
    }
}
