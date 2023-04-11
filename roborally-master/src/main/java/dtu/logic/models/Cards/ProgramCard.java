package dtu.logic.models.Cards;

public class ProgramCard extends Card {
    public int intensity;
    public String name; 

    public ProgramCard(String name, int intensity) {
        this.intensity = intensity;
        this.name = name;
     }

    enum AdditionalProgramCards{
        AGAIN,
        POWERUP,
    }
    public static ProgramCard createProgramCard(String cardName, int intensity){
        switch (cardName){
            case "AGAIN":
                return new ProgramCard("AGAIN",intensity);
            case "POWERUP":
                return new ProgramCard("POWERUP",intensity);
            default:
                return null;
            }
        }
}
