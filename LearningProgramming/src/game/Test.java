package game;

public class Test {
	public static void main(String args[]){
		//GameManegerを起動します
		GameManeger maneger = new GameManeger();

		//Mapの状況を見てます
		Test.look(maneger.getMap());

		//ガンビットを追加します
		maneger.addGambit(true, GambitCondition.CanRightAndLeft, GambitMotion.Right);
		maneger.addGambit(false, GambitCondition.CanRight, GambitMotion.Right);
		maneger.addGambit(true, GambitCondition.CanLeft, GambitMotion.Left);

		//これは最後のガンビット
		maneger.addGambit(false, GambitCondition.CanForward, GambitMotion.Forward);


		//ゲームを開始します。advanceTurnで１ターン進みます
		for(int i = 0; i < 15; i++){
			System.out.println(maneger.getTurn() + ": " +maneger.advanceTurn());
		}

		//Mapの状況を見てます
		Test.look(maneger.getMap());
	}

	public static void look(Map map){
		String[][] viewMap = new String[map.getHeight()][map.getWidth()];
		for(int h = 0; h < map.getHeight(); h++){
			for(int w = 0; w < map.getWidth(); w++){
				Tile tile = map.getTile(new Point2(h, w));
				if(tile.getTileType() == TileType.NORMAL){
					viewMap[h][w] = "0";
				}else if(tile.getTileType() == TileType.WALL){
					viewMap[h][w] = "1";
				}else if(tile.getTileType() == TileType.GOAL){
					viewMap[h][w] = "g";
				}
			}
		}
		if(map.getCharacter().getDirection() == Direction4.DOWN){
			viewMap[map.getCharacter().getLocation().x][map.getCharacter().getLocation().y] = "↓";
		}else if(map.getCharacter().getDirection() == Direction4.LEFT){
			viewMap[map.getCharacter().getLocation().x][map.getCharacter().getLocation().y] = "←";
		}else if(map.getCharacter().getDirection() == Direction4.RIGHT){
			viewMap[map.getCharacter().getLocation().x][map.getCharacter().getLocation().y] = "→";
		}else if(map.getCharacter().getDirection() == Direction4.UP){
			viewMap[map.getCharacter().getLocation().x][map.getCharacter().getLocation().y] = "↑";
		}
		for(int h = 0; h < map.getHeight(); h++){
			for(int w = 0; w < map.getWidth(); w++){
				System.out.print(viewMap[h][w]);
			}
			System.out.println();
		}
	}
}
