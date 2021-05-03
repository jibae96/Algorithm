class Keypad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int [][] keypad = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,2}};
        int [] current = {10,11}; // 현재 왼, 오
        boolean flag = true;

        if(hand.equals("right")) flag = true; // 오른손잡이
        else flag = false; // 왼손잡이

        int now;
        int distanceL, distanceR;

        for(int i=0; i<numbers.length; i++){
            now = numbers[i];
            if(now==1 || now==4 || now==7){
                answer += "L";
                current[0]=now;
            }else if(now==3 || now==6 || now==9){
                answer += "R";
                current[1]=now;
            }else{
                distanceL = Math.abs(keypad[now][0]-keypad[current[0]][0]) + Math.abs(keypad[now][1]-keypad[current[0]][1]);
                distanceR = Math.abs(keypad[now][0]-keypad[current[1]][0]) + Math.abs(keypad[now][1]-keypad[current[1]][1]);
                if(distanceL==distanceR){
                    if(flag){
                        answer += "R";
                        current[1]=now;
                    }else{
                        answer += "L";
                        current[0]=now;
                    }
                }else if(distanceL>distanceR){
                    answer += "R";
                    current[1] = now;
                }else{
                    answer += "L";
                    current[0] = now;
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        int [] numbers1 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        Keypad keypad = new Keypad();
        System.out.println(keypad.solution(numbers1,"left"));
    }
}
