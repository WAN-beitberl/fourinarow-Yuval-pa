import java.util.LinkedList;
import java.util.Scanner;

public class GameLogic {
    private final Player[] players;
    private int[] lowestEmpty;
    private boolean isFirstPlayerTurn;
    public GameLogic(){
        this.players = new Player[2];
        this.players[0] = new Player(true);
        this.players[1] = new Player(false);
        this.isFirstPlayerTurn = true;
        this.lowestEmpty = new int[6];
        for(int i=0; i<6; i++){
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
            Board.printBoard(playerOne,playerTwo);
            gameEnded = checkWin(playerOne,playerTwo);
            this.isFirstPlayerTurn= !this.isFirstPlayerTurn;
        }
    }

    private boolean checkWin(LinkedList<Index> playerOne, LinkedList<Index> playerTwo) {
        return true;
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
