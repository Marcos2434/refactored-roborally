package dtu.logic.models.Board;

public enum TileType {
	
	FLOOR("tiles/floor.png"),
	HOLE("tiles/pit.png"),
	ACID("tiles/acid.png"),
	RADIATION("tiles/radiation.png"),
	WALL("tiles/wall1.png"),
	START("tiles/start.png"),
	CHECKPOINT("tiles/checkpoint1.png"),
	LAZER("tiles/Lazer1.png"),
	BELT("tiles/Lazer1.png");
	
	private String pictureFile;
	
	private TileType(String pictureFile) {
		this.pictureFile = pictureFile;
	}
	
	public String getPictureFile() {
		return pictureFile;
	}
}
