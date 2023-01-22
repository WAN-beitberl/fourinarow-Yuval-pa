
import java.util.LinkedList;

public class Board {
   static final int ROW_LEN =6;
   static final int COULMN_HIGHT = 7;
    public static char[][] printBoard(LinkedList<Index> playerOne, LinkedList<Index> playerTwo){
        char[][] matrix = new char[ROW_LEN][COULMN_HIGHT];
        for(int column = COULMN_HIGHT-1; column>=0; column--){
            for(int row=0; row<ROW_LEN;row++){
                boolean wasFond = false;
                for(Index in: playerOne){
                    if(in.row == row && in.column == column){
                        wasFond =true;
                        matrix[row][column] = 'x';
                        System.out.print("|X");
                    }
                }

                if (!wasFond){
                    for(Index in: playerTwo) {
                        if (in.row == row && in.column == column) {
                            wasFond = true;
                            matrix[row][column] = 'o';
                            System.out.print("|O");
                        }
                    }
                }
                if(!wasFond){
                    System.out.print("| ");
                }
            }

            System.out.println("|");
            System.out.print(" ");
            for(int row=0; row<ROW_LEN;row++){
                System.out.print("--");
            }
            System.out.println();
        }
        return matrix;
    }
}
