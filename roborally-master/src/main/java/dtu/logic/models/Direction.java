package dtu.logic.models;

public enum Direction {
    UP(1),RIGHT(2), DOWN(3), LEFT(4);

    private int id;
    
    private Direction(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public static Direction getDirById(int key){
        for (Direction d : Direction.values()){
            if (d.getId() == (key)){
                return d;
            }
        }
        return null;
    }
    
    
}
