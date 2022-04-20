package problems;

public class LongestPalindromicSubstring {
    int[][] arr ;
    public String longestPalindrome(String s) {
        arr = new int[s.length()][s.length()];
        for(int i = 0; i< s.length(); i++){
                arr[i][i] =  1;
        }
        for(int i = 0; i< s.length()-1; i++){
            if(s.charAt(i)== s.charAt(i+1)) {
                arr[i][i+1] =  1;
            }
        }
        for(int k = 2; k<s.length(); k++){
            int i = 0;
            int j = k;
            while(j<s.length()){
                if(s.charAt(i) == s.charAt(j)){
                    arr[i][j] = arr[i+1][j-1];
                } else {
                    arr[i][j] = 0;
                }
                i++;
                j++;
            }
        }
        int max  = -1;
        int start = 0;
        int end = 0;
        for(int i = 0; i<s.length(); i++) {
            for(int j = i; j<s.length(); j++){
                if(arr[i][j] == 1){
                    if(j - i > max){
                        max = j - i;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        //String s = "zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir";
        String s = "cbbd";
        System.out.println(obj.longestPalindrome(s));
    }
}
