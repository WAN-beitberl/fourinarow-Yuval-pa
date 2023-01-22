import java.util.LinkedList;
import java.util.Scanner;

public class GameLogic {
    private final Player[] players;
    private final int[] lowestEmpty;
    private boolean isFirstPlayerTurn;
    public GameLogic(){
        this.players = new Player[2];
        this.players[0] = new Player(true);
        this.players[1] = new Player(false);
        this.isFirstPlayerTurn = true;
        this.lowestEmpty = new int[Board.ROW_LEN];
        for(int i=0; i<Board.ROW_LEN; i++){
            this.lowestEmpty[i] =0;
        }
    }

    public void gameLoop(){
        boolean gameEnded = false;
        while (!gameEnded){
            Player temp = printMessegeToCurrPlayer();
            int rowNum = getRowNum();
            temp.addMove(rowNum,this.lowestEmpty[rowNum]);
            System.out.println(this.players[0].getPlayedMoves());
            this.lowestEmpty[rowNum]++;


            LinkedList<Index> playerOne = this.players[0].getPlayedMoves();
            LinkedList<Index> playerTwo = this.players[1].getPlayedMoves();
           char[][] mat = Board.printBoard(playerOne,playerTwo);

            if(checkWin(mat)){
                gameEnded = true;
                if(this.isFirstPlayerTurn)
                    System.out.println("Player One is the winner");
                else
                    System.out.println("Player Two is the winner");
            }

            this.isFirstPlayerTurn= !this.isFirstPlayerTurn;
        }
    }

    private boolean checkWin(char[][] mat) {
        for(int row = 0; row<Board.ROW_LEN-3;row++){
            for(int col=0; col<Board.COULMN_HIGHT;col++)
            {
                if(mat[row][col] =='x' || mat[row][col] =='o') {
                    if (mat[row][col] == mat[row + 1][col] &&
                            mat[row][col] == mat[row + 2][col] &&
                            mat[row][col] == mat[row + 3][col]) {
                        return true;
                    }
                }
            }
        }

        for(int row = 0; row<Board.ROW_LEN;row++){
            for(int col=0; col<Board.COULMN_HIGHT-3;col++)
            {
                if(mat[row][col] =='x' || mat[row][col] =='o') {
                    if (mat[row][col] == mat[row][col + 1] &&
                            mat[row][col] == mat[row][col + 2] &&
                            mat[row][col] == mat[row][col + 3]) {
                        return true;
                    }
                }
            }
        }
        for(int row = 0; row<Board.ROW_LEN-3;row++) {
            for (int col = 0; col < Board.COULMN_HIGHT - 3; col++) {
                if (mat[row][col] == 'x' || mat[row][col] == 'o') {
                    if (mat[row][col] == mat[row + 1][col + 1] &&
                            mat[row][col] == mat[row + 2][col + 2] &&
                            mat[row][col] == mat[row + 3][col + 3]) {
                        return true;
                    }

                }
            }
        }
        for(int row = 0; row<Board.ROW_LEN-3;row++){
            for(int col=Board.COULMN_HIGHT-1; col>=3;col--)
            {
                if(mat[row][col] =='x' || mat[row][col] =='o') {
                    if (mat[row][col] == mat[row + 1][col - 1] &&
                            mat[row][col] == mat[row + 2][col - 2] &&
                            mat[row][col] == mat[row + 3][col - 3]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private  Player printMessegeToCurrPlayer(){
        Player temp;
        if(this.isFirstPlayerTurn){
            System.out.println("It's player one's turn please enter a row number");
            temp = this.players[0];
        }
        else {
            System.out.println("It's player two's turn please enter a row number");
            temp = this.players[1];
        }
        return temp;
    }

    private int getRowNum(){
        Scanner scanner = new Scanner(System.in);
        boolean isLegalInput = false;
        int rowNum=-1;
        while(!isLegalInput){
            rowNum = scanner.nextInt();
            rowNum--;
            if (rowNum>=0 && rowNum<Board.ROW_LEN && this.lowestEmpty[rowNum]<Board.COULMN_HIGHT){
                isLegalInput = true;
            }
            else{
                System.out.println("Illegal input please enter a valid row number");
            }
        }
        return rowNum;
    }

}
