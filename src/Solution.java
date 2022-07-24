import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {


    public static void main(String[] args) {
        Solution so = new Solution();

        String s = "abbabba";

        System.out.println(so.solution(s));
    }

    public int solution(String S) {
        // write your code in Java SE 8

        List prefixes = new ArrayList<String>();
        List suffixes = new ArrayList<String>();

        for (int i = 0; i < S.length(); i++) {
            prefixes.add(S.substring(0, i));
            suffixes.add(S.substring(S.length() - i));
        }

        int longest = -1;

        for (int i = 0; i < prefixes.size(); i++) {
            int len = findLength(suffixes, prefixes.get(i).toString());
            if (longest < len) {
                longest = len;
            }
        }

        return longest;
    }

    private int findLength(List<String> arr, String s) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(s)) {
                return s.length();
            }
        }
        return -1;
    }
}