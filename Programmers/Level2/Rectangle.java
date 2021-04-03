public class Rectangle {
    public long solution(int w, int h) {
        long answer = 0;
        int gcd = 0;
        for(int i=1; i<=w && i<=h; i++){
            if(w%i==0 && h%i==0) gcd = i;
        }
        answer = (long)w*h-(w+h-gcd);
        return answer;
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        rect.solution(8,12);
    }
}
