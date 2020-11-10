import java.util.ArrayList;
import java.util.Arrays;

public class main {

/*
String[] strArr = new String[]{
                "R",
                "(x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x)",
                "(x,x,x,R,x,x,x)",
                "(x,x,x,R,x,x,x)",
                "(x,x,x,R,Y,Y,Y)"
        };
 */
    public static class Piece{

        public  void dropPiece(){
            while ( this.y+1 < 6 && connectBoard[this.x][this.y+1] == 'x' ){
                this.y++;
            }

        }
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

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        private char value;


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
    public static char[][] connectBoard;
    public static void main(String[] args){
        String[] strArr = new String[]{
                "R",
                "(x,x,R,x,x,x,x)",
                "(x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x)",
                "(x,x,x,R,x,x,x)",
                "(x,x,x,R,x,x,x)",
                "(x,x,x,R,Y,Y,Y)"
        };

        connectBoard = toCharArr(strArr);

        ArrayList<Piece> possibleStarts = new ArrayList<>();

        for ( int i =0; i < 6; i++){
            if ( connectBoard[0][i] == 'x'){
                Piece possible_start = new Piece();
                possible_start.setValue(strArr[0].charAt(0));
                possible_start.setX(0);
                possible_start.setY(i);
                possible_start.dropPiece();
                possibleStarts.add(possible_start);
            }
        }

        System.out.println(possibleStarts.size());

    }
}
