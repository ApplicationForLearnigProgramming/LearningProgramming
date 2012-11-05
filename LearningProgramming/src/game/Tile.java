package game;

public class Tile {
	private Point2 _point;
	private TileType _tiletype;

	Tile(int x, int y, TileType type){
		_point = new Point2(x, y);
		_tiletype = type;
	}

	public Point2 getLocation(){
		return _point;
	}

	public TileType getTileType(){
		return _tiletype;
	}

	public String toString(){
		return _point + "," + _tiletype;
	}

}
