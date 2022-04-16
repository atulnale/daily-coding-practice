package problems;

import java.util.Scanner;

public class DoubleOrOneThing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cases = 1;
        while(cases <=t) {
            String str = sc.next();

            StringBuilder res = new StringBuilder();
            int i = 0;
            for(i = 0; i< str.length()-1; i++) {
                if(str.charAt(i)> str.charAt(i+1)){
                    res.append(str.charAt(i));
                } else if(str.charAt(i)<str.charAt(i+1)){
                    res.append(str.charAt(i)).append(str.charAt(i));
                } else{
                    int j = i+1;
                    while(j<str.length()){
                        if(str.charAt(i) != str.charAt(j)){
                            break;
                        }
                        j++;
                    }
                    if(j == str.length()){
                        while(j != i){
                            res.append(str.charAt(i));
                            i++;
                        }
                        break;
                    } else if(str.charAt(i) > str.charAt(j)){
                        while(i != j){
                            res.append(str.charAt(i));
                            i++;
                        }
                    } else {
                        while(i != j){
                            res.append(str.charAt(i)).append(str.charAt(i));
                            i++;
                        }
                        i--;
                    }
                }
            }
            if(i!= str.length()){
                res.append(str.charAt(i));
            }
            System.out.println("Case #"+ cases +": "+res.toString());
            cases++;
        }
    }
}
