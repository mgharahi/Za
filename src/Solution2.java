import java.util.Collections;

public class Solution2 {


    public static void main(String[] args) {
        Solution2 so = new Solution2();

        String s = "3x2x";
        String s2 = "8";

        System.out.println(so.solution(s, s2));
    }

    public boolean solution(String S, String T) {
        // write your code in Java SE 8

        S = expandString(S);
        T = expandString(T);
        if (S.length() != T.length())
            return false;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '?' || T.charAt(i) == '?')
                continue;

            if (S.charAt(i) != T.charAt(i))
                return false;
        }

        return true;
    }

    private String expandString(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder digit = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                digit.append(s.charAt(i));
            } else {
                if (digit.length() > 0) {
                    result.append(String.join("", Collections.nCopies(Integer.parseInt(digit.toString()), "?")));
                    digit.setLength(0);
                }
                result.append(s.charAt(i));
            }
        }
        if (digit.length() > 0) {
            result.append(String.join("", Collections.nCopies(Integer.parseInt(digit.toString()), "?")));

        }

        return result.toString();
    }

}
