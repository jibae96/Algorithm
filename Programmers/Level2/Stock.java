class Stock {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        int count;
        int current;
        
        for(int i=0; i<prices.length; i++){
            current = prices[i];
            count = 0;
            for(int j=i+1; j<prices.length; j++){
                count++;
                if(current>prices[j]) break;
            }
            answer[i] = count;
        }
        return answer;
    }
}
