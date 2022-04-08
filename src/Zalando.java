
import java.util.Arrays;
import java.util.Stack;

public class Zalando {
    public static void main(String[] args) {
        Zalando z = new Zalando();

        String[] a1 = new String[]{"x.....>", "..v..x.", ".>..x..", "A......"};
        String[] a2 = new String[]{"...xv", "Ax..^", ".xx.."};
        String[] a3 = new String[]{"...", ">.A"};
        String[] a4 = new String[]{"A.v", "..."};

        MapContainer mc = z.getMap(a4);
        System.out.println(Arrays.deepToString(mc.getMap()));
        System.out.println(z.walk(mc));
    }

    private boolean walk(MapContainer mc) {

        if (mc.getMap()[mc.getaI()][mc.getaJ()] == 0)
            return false;

        short lastI = (short) (mc.getMap().length - 1);
        short lastJ = (short) (mc.getMap()[0].length - 1);

        Stack<point> takenPath = new Stack<>();
        takenPath.push(new point(mc.getaI(), mc.getaJ()));
        while (!takenPath.empty()) {


            point lastP = takenPath.peek();

            if (lastP.getI() + 1 <= lastI && mc.getMap()[(lastP.getI() + 1)][lastP.getJ()] == 1) {//Down
                mc.getMap()[(lastP.getI() + 1)][lastP.getJ()] = -1;
                takenPath.push(new point((short) (lastP.getI() + 1), lastP.getJ()));
            } else if (lastP.getJ() + 1 <= lastJ && mc.getMap()[(lastP.getI())][lastP.getJ() + 1] == 1) {//Right
                mc.getMap()[(lastP.getI())][lastP.getJ() + 1] = -1;
                takenPath.push(new point((lastP.getI()), (short) (lastP.getJ() + 1)));
            } else if (lastP.getI() - 1 >= 0 && mc.getMap()[(lastP.getI() - 1)][lastP.getJ()] == 1) {//Up
                mc.getMap()[(lastP.getI() - 1)][lastP.getJ()] = -1;
                takenPath.push(new point((short) (lastP.getI() - 1), lastP.getJ()));
            } else if (lastP.getJ() - 1 >= 0 && mc.getMap()[(lastP.getI())][lastP.getJ() - 1] == 1) {//Left
                mc.getMap()[(lastP.getI())][lastP.getJ() - 1] = -1;
                takenPath.push(new point((lastP.getI()), (short) (lastP.getJ() - 1)));
            } else {
                takenPath.pop();
            }

            if (!takenPath.empty() && takenPath.peek().getI() == lastI && takenPath.peek().getJ() == lastJ) {
                return true;
            }
        }


        return false;

    }

    private MapContainer getMap(String[] arr) {
        short[][] map = new short[arr.length][arr[0].length()];
        short aI = -1;
        short aJ = -1;

        for (short i = 0; i < arr.length; i++) {
            for (short j = 0; j < arr[0].length(); j++) {
                char c = arr[i].charAt(j);
                map[i][j] = 0;
                if (c == 'A') {
                    aI = i;
                    aJ = j;
                    map[i][j] = -1;
                }
                if (c == '.' || c == 'A') {
                    map[i][j] = checkGuardVision(arr, i, j);
                }
            }
        }

        return new MapContainer(aI, aJ, map);

    }

    private short checkGuardVision(String[] arr, short i, short j) {
        char ch = 'q';
        //Move to left
        for (short jj = (short) (j - 1); jj >= 0; jj--) {
            ch = arr[i].charAt(jj);
            if (ch == '>')
                return 0;
            else if (ch != '.')
                break;
        }
        //Move to right
        for (short jj = (short) (j + 1); jj < arr[0].length(); jj++) {
            ch = arr[i].charAt(jj);
            if (ch == '<')
                return 0;
            else if (ch != '.')
                break;
        }
        //Move to up
        for (short ii = (short) (i - 1); ii >= 0; ii--) {
            ch = arr[ii].charAt(j);
            if (ch == 'v')
                return 0;
            else if (ch != '.')
                break;
        }
        //Move to down
        for (short ii = (short) (i + 1); ii < arr.length; ii++) {
            ch = arr[ii].charAt(j);
            if (ch == '^')
                return 0;
            else if (ch != '.')
                break;
        }
        return 1;
    }


    public class point {

        private short i;
        private short j;

        public point(short i, short j) {
            this.i = i;
            this.j = j;
        }

        public short getI() {
            return i;
        }

        public void setI(short i) {
            this.i = i;
        }

        public short getJ() {
            return j;
        }

        public void setJ(short j) {
            this.j = j;
        }
    }

    private class MapContainer {
        private short aI;
        private short aJ;
        private short[][] map;


        private MapContainer(short aI, short aJ, short[][] map) {
            this.aI = aI;
            this.aJ = aJ;
            this.map = map;
        }

        public short getaI() {
            return aI;
        }

        public void setaI(short aI) {
            this.aI = aI;
        }

        public short getaJ() {
            return aJ;
        }

        public void setaJ(short aJ) {
            this.aJ = aJ;
        }

        public short[][] getMap() {
            return map;
        }

        public void setMap(short[][] map) {
            this.map = map;
        }
    }
}