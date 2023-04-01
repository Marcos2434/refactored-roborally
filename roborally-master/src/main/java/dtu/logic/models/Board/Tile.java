package dtu.logic.models.Board;

public class Tile {
    private String name = "T";
   
    // effect method for tiles, this normal tile does nothing()
    public void effect(){
    System.out.println("Tile effect");
    }

    public String getname(){return this.name;}

}
