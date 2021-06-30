class NumGame {
    public String solution(int n, int t, int m, int p) {
        String [] overNum = {"A","B","C","D","E","F"};
        String answer = "";
        StringBuilder sb = new StringBuilder();
        StringBuilder temp;
        int toN = 0;
        int count = 1;
        sb.append("0");
        while(sb.toString().length()<t*m){
            temp = new StringBuilder();
            toN = count;
            while(toN!=0){
                if(toN%n>9){
                    temp.append(overNum[toN%n-10]);
                }else temp.append(toN%n);

                toN /= n;
            }
            sb.append(temp.reverse());
            count++;
        }

        //System.out.println(sb);

        for(int i=0; i<t; i++){
            answer += sb.toString().charAt((p-1));
            p+=m;
        }
        return answer;
    }
}
