package game;

import java.util.ArrayList;

public class GameManeger {

	private Map _map;
	private ArrayList<Gambit> _gambits;
	private int _turn = 0;
    private boolean _straightFlag = false;
    private boolean _warpFlag = true;
    private final Gambit STRAIGHTGAMBIT = new Gambit(false, GambitCondition.CanForward, GambitMotion.Forward);

	public GameManeger() {
		_gambits = new ArrayList<Gambit>();
	}

	public void setMap(Map map) {
		_map = map;
	}

	/**
	 * ガンビットを追加します.
	 *
	 * @param straight
	 *            直進ONOFF.
	 * @param condition
	 *            ガンビットの条件
	 * @param motion
	 *            ガンビットの行動
	 */
	public void addGambit(boolean straight, GambitCondition condition,
			GambitMotion motion) {
		_gambits.add(new Gambit(straight, condition, motion));
	}

	public void reset() {
		_gambits.clear();
		_map.reset();
		_turn = 0;
	}

	public boolean advanceTurn(){
			_turn++;
	    if(_map.getTile(_map.getCharacter().getLocation()).getTileType() == TileType.WARP_A){
			_map.getCharacter().warp(_map.warp(TileType.WARP_A));
			if(_warpFlag){
				_warpFlag = false;
				return false;
			}else{
				_warpFlag = true;
			}
		}else if(_map.getTile(_map.getCharacter().getLocation()).getTileType() == TileType.WARP_B){
			_map.getCharacter().warp(_map.warp(TileType.WARP_B));
			if(_warpFlag){
				_warpFlag = false;
				return false;
			}else{
				_warpFlag = true;
			}
		}

	    if(_straightFlag){
	        if(STRAIGHTGAMBIT.checkForwardSide(_map)){
	        	_map.getCharacter().move(STRAIGHTGAMBIT.getMotion(_map.getCharacter().getDirection()));
	        }else{
		        for (int i = 0; i < _gambits.size(); i++) {
		            if(_gambits.get(i).goStraight()){
		                if(_gambits.get(i).isOK(_map)){
		                	_map.getCharacter().move(_gambits.get(i).getMotion(_map.getCharacter().getDirection()));
		                	_straightFlag = true;
		                	break;
		                }
		            }else{
		                if(_gambits.get(i).isOK(_map)){
		                    _map.getCharacter().move(_gambits.get(i).getMotion(_map.getCharacter().getDirection()));
		    	        	_straightFlag = false;
		                    break;
		                }
		            }
		        }
	        }
	    }else{
	        for (int i = 0; i < _gambits.size(); i++) {
	            if(_gambits.get(i).goStraight()){
	                if(_gambits.get(i).isOK(_map)){
	                	_map.getCharacter().move(_gambits.get(i).getMotion(_map.getCharacter().getDirection()));
	                	_straightFlag = true;
	                	break;
	                }
	            }else{
	                if(_gambits.get(i).isOK(_map)){
	                    _map.getCharacter().move(_gambits.get(i).getMotion(_map.getCharacter().getDirection()));
	                    break;
	                }
	            }
	        }
	    }

	    if(_map.getTile(_map.getCharacter().getLocation()).getTileType() == TileType.GOAL){
	        return true;
	    }

	    return false;
	}

	public Map getMap() {
		return _map;
	}

	public int getTurn() {
		return _turn;
	}

	public boolean isWarp(){
		return _warpFlag;
	}

}
