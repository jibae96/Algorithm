import java.util.*;

class StickerCollection {
    public int solution(int sticker[]) {
        int answer = 0;
        int len = sticker.length;
        int [] dp1 = new int [len]; // 첫 번째 스티커 선택
        int [] dp2 = new int [len]; // 두 번째 스티커 선택

        if(len<=3){
            Arrays.sort(sticker);
            return sticker[len-1];
        }

        dp1[0] = dp1[1] = sticker[0];
        dp2[0] = 0;
        dp2[1] = sticker[1];

        for(int i=2; i<len-1; i++){
            dp1[i] = Math.max(dp1[i-2]+sticker[i], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2]+sticker[i], dp2[i-1]);
        }

        int last = len-1;
        dp1[last] = Math.max(dp1[last-2], dp1[last-1]);
        dp2[last] = Math.max(dp2[last-1], dp2[last-2]+sticker[last]);

        answer = Math.max(dp1[last], dp2[last]);

        return answer;
    }
}
