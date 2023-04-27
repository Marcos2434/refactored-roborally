package dtu.logic.models;

public class Position {
    private int column;
    private int row;

    public Position(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void addX(int x) {
        this.column += x;
    }

    public void addY(int y) {
        this.row += y;
    }

    public void setColumn(int x) {
        this.column = x;
    }

    public void setRow(int y) {
        this.row = y;
    }

    public void set(int x, int y) {
        this.column = x;
        this.row = y;
    }

    public boolean isOutOfBounds(){
            return getRow() < 0 || getRow() > 12 || getColumn() < 0 || getColumn()>9;
    }

    public String toString() {
        return "(" + this.column + ", " + this.row + ")";
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Position){
            Position pos = (Position) o;
            return this.column == pos.getColumn() && this.row == pos.getRow();
        }
        else{return false;}
    }
}
