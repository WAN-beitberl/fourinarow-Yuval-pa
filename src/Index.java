public class Index {
    public int row;
    public int column;
    public  Index(int row, int column){
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "row: "+ this.row + ", column: "+this.column;
    }
}
