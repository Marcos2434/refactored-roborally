package dtu.logic.models.Board;

public enum TileType {

	//Enumaration for storing image paths for the different tiles
	FLOOR("tiles/floor.png"),
	HOLE("tiles/pit.png"),
	ACID("tiles/acid.png"),
	RADIATION("tiles/radiation.png"),
	WALL("tiles/wall1.png"),
	START("tiles/start.png"),
	CHECKPOINT("tiles/checkpoint1.png"),
	LAZER("tiles/Lazer1.png"),
	BELT("tiles/Lazer1.png"),
	REPAIR("tiles/Repair.png"),
	ACTION("tiles/Action.png");

	private TileType(String pictureFile) {
		this.pictureFile = pictureFile;
	}

	private String pictureFile;
	
	public String getPictureFile() {
		return pictureFile;
	}
}
