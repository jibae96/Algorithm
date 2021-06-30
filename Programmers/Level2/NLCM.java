class NLCM {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1; i<arr.length; i++){
            answer = LCM(answer, arr[i]);
        }
        return answer;
    }
    public int LCM(int a, int b){
        return a*b/GCF(a,b);
    }

    public int GCF(int a, int b){
        int result = 1;

        for(int i=1; i<=a && i<=b; i++){
            if(a%i==0 && b%i==0) result = i;
        }

        return result;
    }
}
