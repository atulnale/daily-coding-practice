package problems;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return helper(s,p,0,0);
    }

    private boolean helper(String s, String p, int i, int j) {
        if(i == s.length() && j == p.length()) return true;
        if(i == s.length() || j == p.length()) return false;
        if(s.charAt(i) == p.charAt(j)){
            return helper(s,p,i+1,j + 1);
        } else if(p.charAt(j)=='.'){
            return helper(s,p,i+1,j+1);
        } else if(p.charAt(j) == '*'){
            boolean res = false;
            for(int k = i; k<=s.length(); k++){
                res = res || helper(s,p,k,j+1);
                if(res){
                    return true;
                }
            }
            return false;
        } else {
            return helper(s,p,i,j+1);
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatching obj = new RegularExpressionMatching();
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(obj.isMatch(s,p));
    }
}
