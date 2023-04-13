package dtu.logic.models.Board;

public enum TileType {
	
	FLOOR("tiles/floor.png"),
	HOLE("tiles/pit.png"),
	ACID("tiles/acid.png"),
	RADIATION("tiles/radiation.png"),
	WALL("tiles/wall.png"),
	START("tiles/start.png");
	
	private String pictureFile;
	
	private TileType(String pictureFile) {
		this.pictureFile = pictureFile;
	}
	
	public String getPictureFile() {
		return pictureFile;
	}
}