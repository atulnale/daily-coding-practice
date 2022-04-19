package problems;

public class KthSymbolInGrammar {
    public int kthGrammar(int n, int k) {
        if(n == 1 && k == 1) return 0;
        int mid = (int) Math.pow(2,n-1) / 2;
        if(k <= mid) return kthGrammar(n-1,k);
        else return 1-kthGrammar(n-1, k - mid);
    }


    public static void main(String[] args) {
        int n = 2;
        int k = 2;
        KthSymbolInGrammar obj= new KthSymbolInGrammar();
        System.out.println(obj.kthGrammar(n, k));
    }
}
