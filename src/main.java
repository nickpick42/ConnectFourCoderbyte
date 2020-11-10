import java.util.Arrays;

public class main {


    public static class Piece{



        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Piece getParent() {
            return parent;
        }

        public void setParent(Piece parent) {
            this.parent = parent;
        }

        private Piece parent;
        private int x;
        private int y;

    }
    public static char[][] toCharArr (String[] strArr){
        char[][] charArr = new char[6][7];

        for ( int i =1 ; i < 7; i++){
            String row = strArr[i].replace("(","").replace(")","").replace(",","");
            for ( int j = 0; j < 7; j++){
                charArr[i-1][j] = row.charAt(j);

            }

        }


        return charArr;
    }

    public static void main(String[] args){
        String[] strArr = new String[]{
                "R",
                "(x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x)",
                "(x,x,x,R,x,x,x)",
                "(x,x,x,R,x,x,x)",
                "(x,x,x,R,Y,Y,Y)"
        };

        char[] test_row = toCharArr(strArr)[0];

        System.out.println(Arrays.toString(test_row));







    }
}
