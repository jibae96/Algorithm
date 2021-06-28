class DiffBit {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int index = 0;

        for(long num : numbers){
            // 짝수일 때
            // 이진수 마지막이 항상 0으로 끝나기 때문에 그 숫자에 1만 더해주면 된됨
            if(num%2==0){
                answer[index++] = num+1;
                //System.out.println("짝수");
            }

            // 홀수일 때
            // 이진수에서 0이 있을 때와 없을 때로 나뉨
            // 1. 0이 있으면 가장 낮은 0이 몇번째 있는지 확인 후 01->10으로 바꿈
            // 2. 0이 없으면 맨 앞에 1을 붙이고 가장 큰 자리수 1을 0으로 바꿈
            else{
                long result = num;
                int count = 0;

                while(num!=0){
                    count++;
                    if(num%2==0) break;
                    num /= 2;
                }

                //System.out.println(result+"-"+count);
                // 이진수가 모두 1로 구성되어 있을 때
                if(num == 0){
                    result -= Math.pow(2,count-1);
                    result += Math.pow(2,count);
                    //System.out.println(result+"!");
                }else{ // 이진수에 0이 포함되어 있을 때
                    result -= Math.pow(2,count-2);
                    result += Math.pow(2,count-1);
                }
                answer[index++] = result;
            }
        }
        return answer;
    }
}
