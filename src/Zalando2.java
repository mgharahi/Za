import java.util.Arrays;

public class Zalando2 {
    public static void main(String[] args) {
        Zalando2 z = new Zalando2();

        String a1 = "CBACD";
        String a2 = "CABABD";
        String a3 = "ACBDACBD";//1254


        System.out.println(z.Transform(a3));
    }


    private String Transform(String s) {
        boolean found;
        int i = 0;
        String subS = "";
        do {
            i = 0;
            found = false;
            while (i + 2 <= s.length() /*&& s.length() > 1*/) {

                subS = s.substring(i, i + 2);
                if (subS.equals("AB") || subS.equals("BA") || subS.equals("CD") || subS.equals("DC")) {
                    found = true;
                    s = s.substring(0, i) + s.substring(i + 2);
                    i--;
                }
                i++;
            }
        } while (found);

        return s;
    }
}