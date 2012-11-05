package game;

import java.util.ArrayList;

public class GameManeger {

    private Map _map;
    private ArrayList<Gambit> _gambits;
    private int _turn = 0;

    public GameManeger(){
        _map = new Map("data/stage001.map");
        _gambits = new ArrayList<Gambit>();
    }

    /**
     * ガンビットを追加します.
     * @param straight 直進ONOFF.
     * @param condition ガンビットの条件
     * @param motion ガンビットの行動
     */
    public void addGambit(boolean straight, GambitCondition condition, GambitMotion motion){
        _gambits.add(new Gambit(straight, condition, motion));
    }

    public void reset(){
        _gambits.clear();
        _turn = 0;
    }

    public boolean advanceTurn(){
        _turn++;
        for (int i = 0; i < _gambits.size(); i++) {
            if(_gambits.get(i).goStraight()){
                if(_gambits.get(i).isOK(_map)){
                    _map.getCharacter().move(_gambits.get(i).getMotion(_map.getCharacter().getDirection()));
                    while(_gambits.get(i).checkForwardSide(_map)){
                        _map.getCharacter().move(_map.getCharacter().getDirection());
                    }
                    break;
                }
            }else{
                if(_gambits.get(i).isOK(_map)){
                    _map.getCharacter().move(_gambits.get(i).getMotion(_map.getCharacter().getDirection()));
                    break;
                }
            }
        }
        if(_map.getTile(_map.getCharacter().getLocation()).getTileType() == TileType.GOAL){
            return true;
        }
        return false;
    }

    public Map getMap(){
        return _map;
    }

    public int getTurn(){
        return _turn;
    }



}
