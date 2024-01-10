package graphs.disjoin_sets.nov_2022;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        int i = -1;
        int j = 0;
        while(j<s.length()){
            char ch = s.charAt(j);
            if(ch == ' '){
                if(i != -1 && builder.charAt(i) !=' '){
                    builder.append(' ');
                    i++;
                }

            } else{
                builder.append(ch);
                i++;
            }
            j++;
        }
        String[] arr = builder.toString().split(" ");
        builder = new StringBuilder();
        i = arr.length - 1;
        while(i >= 0) {
            builder.append(arr[i]);
            builder.append(" ");
            i--;
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInString obj= new ReverseWordsInString();
        String s= "   the sky  is  blue  ";
        System.out.println(obj.reverseWords(s));
    }
}
