class Balloon {
    public int solution(int[] a) {
        int answer = 2;
        int left, right;

        if(a.length<2) return 1;

        left = a[0];
        right = a[a.length-1];

        for(int i=1; i<a.length-1; i++){
            if(a[i] < left){
                left = a[i];
                answer++;
            }
            if(a[a.length-1-i] < right){
                right = a[a.length-1-i];
                answer++;
            }
        }

        if(left==right) answer--;

        return answer;
    }
}
