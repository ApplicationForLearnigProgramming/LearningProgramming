package game;

public class Character {
	private Direction4 _direction;
	private Point2 _point;

	Character(Point2 point,Direction4 direction) {
		_direction = direction;
		_point = point;
	}

	public Direction4 getDirection(){
		return _direction;
	}

	public Point2 getLocation(){
		return _point;
	}

	public void warp(Point2 point){
		_point = point;
	}

	public void move(Direction4 direction){
		_point = _point.move(direction);
		_direction = direction;
	}


}
