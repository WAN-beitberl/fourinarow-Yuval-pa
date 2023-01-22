
import java.util.LinkedList;

public class Board {
   static final int ROW_LEN =6;
   static final int COULMN_HIGHT = 7;
    public static void printBoard(LinkedList<Index> playerOne, LinkedList<Index> playerTwo){
        for(int column = COULMN_HIGHT-1; column>=0; column--){
            for(int row=0; row<ROW_LEN;row++){
                boolean wasFond = false;
                for(Index in: playerOne){
                    if(in.row == row && in.column == column){
                        wasFond =true;
                        System.out.print("|X");
                    }
                }

                if (!wasFond){
                    for(Index in: playerTwo) {
                        if (in.row == row && in.column == column) {
                            wasFond = true;
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
    }
}
