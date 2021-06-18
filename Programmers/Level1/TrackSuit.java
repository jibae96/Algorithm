class TrackSuit {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int [] students = new int [n];

        for(int temp : lost){
            students[temp-1]--;
        }

        for(int temp : reserve){
            students[temp-1]++;
        }

        for(int i=0; i<students.length; i++){
            if(students[i]<0){
                if(i!=0 && students[i-1]>0){
                    students[i]++;
                    students[i-1]--;
                }else if(i!=n-1 && students[i+1]>0){
                    students[i]++;
                    students[i+1]--;
                }
            }
        }

        for(int temp : students){
            if(temp>=0) answer++;
        }

        return answer;
    }
}
