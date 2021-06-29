import java.util.*;

class FileSort {
    public String[] solution(String[] files) {

        Arrays.sort(files,(o1,o2)->{
            String [] file1 = filesplit(o1);
            String [] file2 = filesplit(o2);
            if(file1[0].equals(file2[0])){
                int num1 = Integer.parseInt(file1[1]);
                int num2 = Integer.parseInt(file2[1]);
                return num1-num2;
            }else return file1[0].compareTo(file2[0]);

        });

        return files;
    }
    public String[] filesplit(String str){
        String [] result = new String[2];
        int i = 0;
        String head = "";
        String number = "";

        for(;i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch>='0' && ch<='9') break;
            head += ch;
        }
        for(;i<str.length(); i++){
            char ch = str.charAt(i);
            if(!(ch>='0' && ch<='9')) break;
            number += ch;
        }
        result[0] = head.toUpperCase();
        result[1] = number;

        return result;
    }
}
