package dtu.logic.models.Board;

import dtu.logic.models.Direction;

public class TileBelt extends Tile {
    private Direction Dir;

    

    public TileBelt(Direction dir) {
        super(TileType.BELT);
        this.Dir = dir;
    }

}