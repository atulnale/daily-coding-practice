package march_31_2022;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        char[][] arr = new char[numRows][(s.length()  + 1)];
        for(int i = 0; i< arr.length; i++) {
            for(int j = 0; j<arr[0].length; j++){
                arr[i][j]='0';
            }
        }
        int pos = 0;
        boolean goDown = true;
        int i = 0;
        int j = 0;
        while(pos < s.length()) {
            arr[i][j] = s.charAt(pos);
            if(goDown){
                if(i == numRows - 1) {
                    goDown = false;
                    i = i-1;
                    j++;
                } else {
                    i++;
                }
            }else {
                if(i == 0) {
                    goDown = true;
                    i = i+ 1;
                } else {
                    i = i- 1;
                    j++;
                }
            }
            pos++;
        }
        StringBuilder builder = new StringBuilder();
        for( i = 0; i< arr.length; i++) {
            for( j = 0; j<arr[0].length; j++){
                if(arr[i][j] != '0'){
                    builder.append(arr[i][j]);
                }
            }
        }
        return builder.toString();

    }

}
