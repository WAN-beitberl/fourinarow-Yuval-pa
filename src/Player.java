import java.util.LinkedList;

public class Player {
        private final boolean isX;
        private LinkedList<Index> playedMoves;

        public Player(boolean isX){
            this.isX = isX;
            this.playedMoves = new LinkedList<>();
        }

        public boolean getIsX(){return  this.isX;}

        public void addMove(int row, int column){
            this.playedMoves.add(new Index(row,column));
        }

        public LinkedList<Index> getPlayedMoves(){
            return this.playedMoves;
        }
}
