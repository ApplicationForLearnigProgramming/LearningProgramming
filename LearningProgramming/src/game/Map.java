package game;

import java.util.ArrayList;

public class Map {
	private final int UP = 0;
	private final int RIGHT = 1;
	private final int LEFT = 2;
	private final int DOWN = 3;
	private final int NORMAL = 0;
	private final int WALL = 1;
	private final int GOAL = 2;
	private final int WARP_A = 3;
	private final int WARP_B = 4;

	private Point2 _startCharaPoint = null;
	private Direction4 _startCharaDirection = null;

	private ArrayList<Tile> _tiles = new ArrayList<Tile>();
	private Character _chara;
	private Tile warp_A;
	private Tile warp_B;
	private boolean _warpFlag = true;
	private int _width = 0;
	private int _height = 0;
	private String _filename = null;
	private String _stageSize = null;
	private String _charaInfo = null;
	private String _stageData = null;
	// private int[][] map = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
	// {1, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
	// {1, 1, 0, 1, 0, 1, 0, 1, 0, 1}, {1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
	// {1, 1, 0, 1, 0, 1, 2, 1, 0, 1}, {1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
	// {1, 1, 0, 1, 0, 1, 0, 1, 0, 1}, {1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
	// {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

	public Map(String stageSize, String charaInfo, String stageData) {
		_stageSize = stageSize;
		_charaInfo = charaInfo;
		_stageData = stageData;

		// マップの幅、高さ
		String size[] = _stageSize.split(",");
		_width = Integer.parseInt(size[0]);
		_height = Integer.parseInt(size[1]);

		// キャラクターの位置、
		String chara[] = _charaInfo.split(",");
		Direction4 charaDirect;
		switch (Integer.parseInt(chara[2])) {
			case UP :
				charaDirect = Direction4.UP;
				break;
			case RIGHT :
				charaDirect = Direction4.RIGHT;
				break;
			case LEFT :
				charaDirect = Direction4.LEFT;
				break;
			case DOWN :
				charaDirect = Direction4.DOWN;
				break;
			default :
				charaDirect = Direction4.DOWN;
		}
		_chara = new Character(new Point2(Integer.parseInt(chara[0]),
				Integer.parseInt(chara[1])), charaDirect);
		_startCharaDirection = charaDirect;
		_startCharaPoint = new Point2(Integer.parseInt(chara[0]),
				Integer.parseInt(chara[1]));

		// タイルの初期化
		for (int h = 0; h < _height; h++) {
			String line[] = _stageData.split("\n");
			String tile[] = line[h].split(",");
			for (int w = 0; w < _width; w++) {
				TileType tiletype;
				switch (Integer.parseInt(tile[w])) {
					case NORMAL :
						tiletype = TileType.NORMAL;
						break;
					case WALL :
						tiletype = TileType.WALL;
						break;
					case GOAL :
						tiletype = TileType.GOAL;
						break;
					case WARP_A :
						tiletype = TileType.WARP_A;
						warp_A = new Tile(h, w, TileType.WARP_A);
						break;
					case WARP_B :
						tiletype = TileType.WARP_B;
						warp_B = new Tile(h, w, TileType.WARP_B);
						break;

					default :
						tiletype = TileType.NORMAL;
				}
				_tiles.add(new Tile(h, w, tiletype));
			}
		}
	}

	// public Map(BufferedReader br) {
	// try {
	// String line;
	//
	// // マップの幅、高さ
	// if (br != null) {
	// line = br.readLine();
	// String size[] = line.split(",");
	// _width = Integer.parseInt(size[0]);
	// _height = Integer.parseInt(size[1]);
	//
	// // キャラクターの位置、
	// line = br.readLine();
	// String charaInfo[] = line.split(",");
	// Direction4 charaDirect;
	// switch (Integer.parseInt(charaInfo[2])) {
	// case UP :
	// charaDirect = Direction4.UP;
	// break;
	// case RIGHT :
	// charaDirect = Direction4.RIGHT;
	// break;
	// case LEFT :
	// charaDirect = Direction4.LEFT;
	// break;
	// case DOWN :
	// charaDirect = Direction4.DOWN;
	// break;
	// default :
	// charaDirect = Direction4.DOWN;
	// }
	// _chara = new Character(new Point2(
	// Integer.parseInt(charaInfo[0]),
	// Integer.parseInt(charaInfo[1])), charaDirect);
	// _startCharaDirection = charaDirect;
	// _startCharaPoint = new Point2(Integer.parseInt(charaInfo[0]),
	// Integer.parseInt(charaInfo[1]));
	//
	// // タイルの初期化
	// for (int h = 0; h < _height; h++) {
	// line = br.readLine();
	// String tile[] = line.split(",");
	// for (int w = 0; w < _width; w++) {
	// TileType tiletype;
	// switch (Integer.parseInt(tile[w])) {
	// case NORMAL :
	// tiletype = TileType.NORMAL;
	// break;
	// case WALL :
	// tiletype = TileType.WALL;
	// break;
	// case GOAL :
	// tiletype = TileType.GOAL;
	// break;
	// case WARP_A :
	// tiletype = TileType.WARP_A;
	// warp_A = new Tile(h, w, TileType.WARP_A);
	// break;
	// case WARP_B :
	// tiletype = TileType.WARP_B;
	// warp_B = new Tile(h, w, TileType.WARP_B);
	// break;
	//
	// default :
	// tiletype = TileType.NORMAL;
	// }
	// _tiles.add(new Tile(h, w, tiletype));
	// }
	// }
	// }
	// } catch (IOException e) {
	// System.out.println(e);
	// }
	// }

	public void reset() {
		_chara = new Character(_startCharaPoint, _startCharaDirection);
	}

	public int getWidth() {
		return _width;
	}

	public int getHeight() {
		return _height;
	}

	public ArrayList<Tile> getTiles() {
		return _tiles;
	}

	public Tile getTile(Point2 point) {
		for (int i = 0; i < _tiles.size(); i++) {
			if (point.equals(_tiles.get(i).getLocation())) {
				return _tiles.get(i);
			}
		}
		return null;
	}
	public Point2 warp(TileType type) {
		if (_warpFlag) {
			if (type == TileType.WARP_A) {
				_warpFlag = false;
				return warp_B.getLocation();
			} else {
				_warpFlag = false;
				return warp_A.getLocation();
			}
		} else {
			_warpFlag = true;
			if (type == TileType.WARP_A) {
				return warp_A.getLocation();
			} else {
				return warp_B.getLocation();
			}
		}
	}

	public Character getCharacter() {
		return _chara;
	}

	public String getFilename() {
		return _filename;
	}

	public String getStageSize() {
		return _stageSize;
	}

	public String getCharaInfo() {
		return _charaInfo;
	}

	public String getStageData() {
		return _stageData;
	}

}
