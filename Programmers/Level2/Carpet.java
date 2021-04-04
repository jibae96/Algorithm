public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
        int width=3;
        int height=3;
        int total = brown + yellow;

        for(int i=3; ; i++){
            width = i;
            height = 3;
            while(width>=height){
                if(width*height==total && (width-2)*(height-2)==yellow){
                    answer[0]=width;
                    answer[1]=height;
                    return answer;
                }
                height++;
            }
        }
    }

    public static void main(String[] args) {
        Carpet carpet = new Carpet();
        int brown = 10;
        int yellow = 2;
        carpet.solution(brown,yellow);
    }
}
