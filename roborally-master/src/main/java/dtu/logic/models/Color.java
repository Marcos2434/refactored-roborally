package dtu.logic.models;

public enum Color {
    
    // 8 DIFFERENT COLORS for the robots
    RED("colors/red.png"),
    BLUE("colors/blue.png"),
    GREEN("colors/green.png"),
    YELLOW("colors/yellow.png"),
    ORANGE("colors/orange.png"),
    PURPLE("colors/purple.png"),
    WHITE("colors/white.png"),
    BLACK("colors/black.png");

    private String pictureFile;
    
	private Color(String pictureFile) {
		this.pictureFile = pictureFile;
	}

	
	public String getPictureFile() {
		return pictureFile;
	}
    
}
