import java.util.ArrayList;
import java.util.Arrays;

public class main {


    public static class Piece{

        public  void dropPiece(){
            while ( this.x+1 < 6 && connectBoard[this.x+1][this.y] == 'x' ){
                this.x++;
            }

        }
        public boolean isWinner(){

            boolean isGood = true;
            if ( this.x+4 <= 6 ){
                int count = 0;
                for ( int i = this.x; i < this.x+4; i++){
                    if ( connectBoard[i][this.y] == this.getValue() ){
                        count++;
                    }
                }
                if ( count == 4){
                    return true;
                }
            }
            if ( this.x-4 >= -1 ){
                int count =0;
                for ( int i = this.x; i > this.x-4; i--){
                    if ( connectBoard[i][this.y] == this.getValue() ){
                        count++;
                    }
                }
                if ( count == 4 ){
                    return true;
                }

            }
            if ( this.y+4 <= 7 ){
                int count = 0;
                for ( int i = this.y; i < this.y+4; i++ ){
                    if ( connectBoard[this.x][i] == this.getValue() ){
                       count ++;
                    }
                }
                if ( count == 4 ){
                    return true;
                }
            }
            if ( this.y-4 >= -1 ){
                int count = 0;
                for ( int i = this.y; i > this.y-3; i-- ){
                    if ( connectBoard[this.x][i] == this.getValue() ){
                        count++;
                    }
                }
                if ( count == 4 ){
                    return  true;
                }

            }

            return false;
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
                "Y",
                "(x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x)",
                "(x,x,x,x,x,x,x)",
                "(x,x,x,R,Y,Y,Y)"
        };

        connectBoard = toCharArr(strArr);



        Piece winningPiece = null;

        for ( int i =0; i < 7; i++){
            if ( connectBoard[0][i] == 'x'){
                Piece possible_start = new Piece();
                possible_start.setValue(strArr[0].charAt(0));
                possible_start.setX(0);
                possible_start.setY(i);
                possible_start.dropPiece();
                connectBoard[possible_start.getX()][possible_start.getY()] = possible_start.getValue();

                if ( i == 3 ){
                    winningPiece = possible_start;
                }
            }
        }

        System.out.println(winningPiece.isWinner());


    }
}
