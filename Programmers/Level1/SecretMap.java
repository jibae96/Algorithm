class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String [n];
        int [] temp;
        int index;

        for(int i=0; i<arr1.length; i++){
            temp = new int [n];
            index = n-1;
            answer[i]="";
            while(arr1[i]!=0){
                temp[index--] = arr1[i]%2;
                arr1[i] /= 2;
            }
            index = n-1;
            while(arr2[i]!=0){
                if(temp[index]==0){
                    temp[index--] = arr2[i]%2;
                }else index--;
                arr2[i] /= 2;
            }
            for(int j=0; j<n; j++){
                if(temp[j]==1) answer[i] += "#";
                else answer[i] += " ";
            }
        }
        return answer;
    }
}
