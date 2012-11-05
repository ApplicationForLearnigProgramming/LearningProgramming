package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Map {
	private final int UP = 0;
	private final int RIGHT = 1;
	private final int LEFT = 2;
	private final int DOWN = 3;
	private final int NORMAL = 0;
	private final int WALL = 1;
	private final int GOAL = 2;

	private ArrayList<Tile> _tiles = new ArrayList<Tile>();
	private Character _chara;
	private int _width;
	private int _height;

	Map(String data){
		try{
			FileReader inFileRead = new FileReader(data);
			BufferedReader br = new BufferedReader(inFileRead);
			String line;

			//マップの幅、高さ
			line = br.readLine();
			String size[] = line.split(",");
			_width = Integer.parseInt(size[0]);
			_height = Integer.parseInt(size[0]);

			//キャラクターの位置、
			line = br.readLine();
			String charaInfo[] = line.split(",");
			Direction4 charaDirect;
            switch (Integer.parseInt(charaInfo[2])) {
	            case UP:
	                charaDirect = Direction4.UP;
	                break;
	            case RIGHT:
	            	charaDirect = Direction4.RIGHT;
	            	break;
	            case LEFT:
	            	charaDirect = Direction4.LEFT;
	            	break;
	            case DOWN:
	            	charaDirect = Direction4.DOWN;
	            	break;
	            default:
	            	charaDirect = Direction4.DOWN;
            }
			_chara = new Character(new Point2(Integer.parseInt(charaInfo[0]),Integer.parseInt(charaInfo[1])),charaDirect);


			//タイルの初期化
			for(int h = 0; h < _height; h++){
				line = br.readLine();
				String tile[] = line.split(",");
				for(int w = 0; w < _width; w++ ){
	                TileType tiletype;
	    			switch (Integer.parseInt(tile[w])) {
			            case NORMAL:
			                 tiletype = TileType.NORMAL;
			                break;
			            case WALL:
			            	tiletype = TileType.WALL;
			            	break;
			            case GOAL:
			            	tiletype = TileType.GOAL;
			            	break;
			            default:
			            	tiletype = TileType.NORMAL;
		            }
	    			_tiles.add(new Tile(h, w, tiletype));
				}
			}
		}catch(IOException e){
			  System.out.println(e);
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
