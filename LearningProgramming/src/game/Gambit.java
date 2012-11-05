package game;

public class Gambit {
	private boolean _straight;
	private GambitCondition _condition;
	private GambitMotion _motion;

	Gambit(boolean staright, GambitCondition condition, GambitMotion motion){
		_straight = staright;
		_condition = condition;
		_motion = motion;
	}

	public boolean goStraight(){
		return _straight;
	}

	public Direction4 getMotion(Direction4 direction){
		switch(_motion){
			case Forward:
				return direction;
			case Back:
				return changeBackDirection(direction);
			case Left:
				return changeLeftDirection(direction);
			case Right:
				return changeRightDirection(direction);
			default:
				return Direction4.STOP;
		}
	}

	public boolean isOK(Map map){
		switch (_condition) {
			case CanForward:
				if(checkForwardSide(map)) return true;
	            break;
			case CanRight:
				if(checkRightSide(map)) return true;
	            break;
			case CanBack:
				if(checkBackSide(map)) return true;
	            break;
			case CanLeft:
				if(checkLeftSide(map)) return true;
	            break;
			case CanALL:
				if(checkRightSide(map)&&checkBackSide(map)&&checkLeftSide(map)&&checkForwardSide(map)) return true;
	            break;
			case CanForwardAndLeft:
				if(checkForwardSide(map)&&checkLeftSide(map)) return true;
	            break;
			case CanForwardAndRight:
				if(checkForwardSide(map)&&checkRightSide(map)) return true;
	            break;
			case CanRightAndLeft:
				if(checkLeftSide(map)&&checkRightSide(map)) return true;
				break;
			case CanRightAndLeftAndForward:
				if(checkForwardSide(map)&&checkLeftSide(map)&&checkRightSide(map)) return true;
				break;
			default:
				return false;
		}

		return false;
	}

	private boolean checkLeftSide(Map map){
		Point2 position = new Point2().move(changeLeftDirection(map.getCharacter().getDirection())).add(map.getCharacter().getLocation());
		if( map.getTile(position).getTileType() == TileType.WALL) return false;
		return true;
    }

	private boolean checkRightSide(Map map){
		Point2 position = new Point2().move(changeRightDirection(map.getCharacter().getDirection())).add(map.getCharacter().getLocation());
		if( map.getTile(position).getTileType() == TileType.WALL) return false;
		return true;

    }

	private boolean checkBackSide(Map map){
		Point2 position = new Point2().move(changeBackDirection(map.getCharacter().getDirection())).add(map.getCharacter().getLocation());
		if( map.getTile(position).getTileType() == TileType.WALL) return false;
		return true;
	}

	public boolean checkForwardSide(Map map){
		Point2 position = new Point2().add(map.getCharacter().getDirection().toPoint()).add(map.getCharacter().getLocation());
		if( map.getTile(position).getTileType() == TileType.WALL) return false;
		return true;
	}

	private Direction4 changeLeftDirection(Direction4 direction){
		switch (direction) {
			case UP:
	            return Direction4.LEFT;
	        case LEFT:
	        	return Direction4.DOWN;
	        case DOWN:
	        	return Direction4.RIGHT;
	        case RIGHT:
	        	return Direction4.UP;
	        default:
	        	return Direction4.STOP;
		}
	}

	private Direction4 changeRightDirection(Direction4 direction){
		switch (direction) {
			case UP:
	            return Direction4.RIGHT;
	        case LEFT:
	        	return Direction4.UP;
	        case DOWN:
	        	return Direction4.LEFT;
	        case RIGHT:
	        	return Direction4.DOWN;
	        default:
	        	return Direction4.STOP;
		}
	}

	private Direction4 changeBackDirection(Direction4 direction){
		switch (direction) {
			case UP:
	            return Direction4.DOWN;
	        case LEFT:
	        	return Direction4.RIGHT;
	        case DOWN:
	        	return Direction4.UP;
	        case RIGHT:
	        	return Direction4.RIGHT;
	        default:
	        	return Direction4.STOP;
		}
	}


}
