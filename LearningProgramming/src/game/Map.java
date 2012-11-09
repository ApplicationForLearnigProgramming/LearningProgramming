package game;

import java.util.ArrayList;

public class Map {
	private final int NORMAL = 0;
	private final int WALL = 1;
	private final int GOAL = 2;

	private ArrayList<Tile> _tiles = new ArrayList<Tile>();
	private Character _chara;
	private int _width;
	private int _height;
	private int[][]  map = { {1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,1},
			{1,1,0,1,0,1,0,1,0,1},
			{1,1,0,1,0,1,0,1,0,1},
			{1,1,0,1,0,1,0,1,0,1},
			{1,1,0,1,0,1,2,1,0,1},
			{1,1,0,1,0,1,0,1,0,1},
			{1,1,0,1,0,1,0,1,0,1},
			{1,0,0,1,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1} };

	Map(){
		//マップの幅、高さ
		_width = 10;
		_height = 10;

		//キャラクターの位置、
		Direction4 charaDirect = Direction4.RIGHT;
		_chara = new Character(new Point2(8, 1), charaDirect);

		//タイルの初期化
		for(int h = 0; h < _height; h++){
			for(int w = 0; w < _width; w++ ){

                TileType tiletype = TileType.WALL;
                if(map[h][w] == NORMAL) tiletype = TileType.NORMAL;
                else if(map[h][w] == WALL) tiletype = TileType.WALL;
                else if(map[h][w] == GOAL) tiletype = TileType.GOAL;
    			_tiles.add(new Tile(h, w, tiletype));
			}
		}
	}

	public int getWidth(){
		return _width;
	}

	public int getHeight(){
		return _height;
	}

	public ArrayList<Tile> getTiles(){
		return _tiles;
	}

	public Tile getTile(Point2 point){
		for (int i = 0; i < _tiles.size(); i++) {
			if(point.equals(_tiles.get(i).getLocation())){
				return _tiles.get(i);
			}
		}
		return null;
	}

	public Character getCharacter(){
		return _chara;
	}


}
