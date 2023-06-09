package dtu.roborally.view;

public enum TileType {
	
	OPEN_FLOOR("tiles/floor.png"),
	PIT("tiles/pit.png"),
	ACID("tiles/acid.png"),
	RADIATION("tiles/radiation.png");
	
	private String pictureFile;
	
	private TileType(String pictureFile) {
		this.pictureFile = pictureFile;
	}
	
	public String getPictureFile() {
		return pictureFile;
	}
}
