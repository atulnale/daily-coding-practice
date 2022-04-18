package problems;

public class NthSteps {
    public static void main(String[] args) {
        int n  = 2;
        int num1 = 1;
        int num2 = 2;
        if(n <=2){
            System.out.println(n);
            return;
        }
        int i = 3;
        int ans = 0;
        while(i<=n){
            ans = num1 + num2;
            num1 = num2;
            num2 = ans;
            i++;
        }
        System.out.println(ans);
    }
}
